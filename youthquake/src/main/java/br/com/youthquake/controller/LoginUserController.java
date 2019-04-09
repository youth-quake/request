package br.com.youthquake.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.User;
import br.com.youthquake.responses.Response;
import br.com.youthquake.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginUserController {

	@Autowired
	private UserService userService;

	// Teste API

	@PostMapping(path = "/Login")
	public ResponseEntity<Response<User>> cadastrar(@Valid @RequestBody UserDTO userDto, BindingResult result) {

		Response<User> response = new Response<User>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		User userInclude = this.userService.include(userDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDto.getId())
				.toUri();

		response.setData(userInclude);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping("/aa")
	public ResponseEntity<List<User>> listar() {
		List<User> users = null;
		users = userService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
}