package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.UserDTO;
import com.login.exception.AdminException;
import com.login.exception.UserException;
import com.login.model.User;
import com.login.service.JWTService;
import com.login.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private JWTService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;

	@Value("${admin.secretKey}")
	private String secretKey;

	@GetMapping("/user")
	public ResponseEntity<String> welcomePage() {
		return new ResponseEntity<>("Welcome to the website !", HttpStatus.OK);
	}

	@PostMapping("/user/signup")
	public ResponseEntity<User> userSignUp(@RequestBody User user) throws UserException {
		return new ResponseEntity<>(userService.addUser(user, false), HttpStatus.ACCEPTED);
	}

	@PostMapping("/user/signup/{secretKey}")
	public ResponseEntity<User> adminSignUp(@RequestBody User user, @PathVariable String secretKey)
			throws UserException, AdminException {
		if (!secretKey.equals(this.secretKey))
			throw new AdminException("Wrong Passcode.");

		return new ResponseEntity<>(userService.addUser(user, true), HttpStatus.ACCEPTED);
	}

	@GetMapping("/user/userLogin")
	public ResponseEntity<String> userLogin() {
		return new ResponseEntity<>("Welcome User!", HttpStatus.OK);
	}

	@GetMapping("/user/adminLogin")
	public ResponseEntity<String> adminLogin() {
		return new ResponseEntity<>("Welcome Admin !", HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody UserDTO authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getEmail());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}

}
