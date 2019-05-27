package br.com.youthquake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.youthquake.dto.FriendsDTO;
import br.com.youthquake.service.FriendsService;

@RestController
public class FriendsREST {
	
	@Autowired
	private FriendsService friendService;
	
	@CrossOrigin
	@GetMapping("/friend")
	public ResponseEntity<Boolean> friend(@RequestBody FriendsDTO friend) {
		return ResponseEntity.ok().body(friendService.verifyFriends(friend));
	}
	
	@CrossOrigin
	@DeleteMapping("/friend/delete/{idFriends}")
	public ResponseEntity<String> removeFriend(@PathVariable long idFriends){
		friendService.deleteFriends(idFriends);
		return ResponseEntity.ok().body("Deletado com sucesso!");
	}
}
