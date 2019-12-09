package com.wildschool.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class DoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		String menu = "";
		menu += "<ul>\n";
		menu += "<li>\n";
		menu += "<a href=\"doctor/0\">Doctor (other)</a>\n";
		menu += "</li>\n";
		menu += "<li>\n";
		menu += "<a href=\"doctor/9\">Doctor9</a>\n";
		menu += "</li>\n";
		menu += "<li>\n";
		menu += "<a href=\"doctor/10\">Doctor10</a>\n";
		menu += "</li>\n";
		menu += "<li>\n";
		menu += "<a href=\"doctor/11\">Doctor11</a>\n";
		menu += "</li>\n";
		menu += "<li>\n";
		menu += "<a href=\"doctor/12\">Doctor12</a>\n";
		menu += "</li>\n";
		menu += "<li>\n";
		menu += "<a href=\"doctor/13\">Doctor13</a>\n";
		menu += "</li>\n";
		menu += "</ul>\n";
		return menu;
	}

	@RequestMapping("/doctor/{number}")
	@ResponseBody
	public ResponseEntity<String> doctor(@PathVariable int number) {
		String name = "";
		if (number <= 8) {	
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See another doctor!");
//			return new ResponseEntity<String>(HttpStatus.SEE_OTHER);
		} else {
			switch (number) {
			case 9:
				name = "<h3>Christopher Eccleston</h3>";
				name += "<a href='/'>back to root</a>";
				break;
			case 10:
				name = "<h3>David Tennant</h3>";
				name += "<a href='/'>back to root</a>";
				break;
			case 11:
				name = "<h3>Matt Smith</h3>";
				name += "<a href='/'>back to root</a>";
				break;
			case 12:
				name = "<h3>Peter Capaldi</h3>";
				name += "<a href='/'>back to root</a>";
				break;
			case 13:
				name = "<h3>Jodie Whittaker</h3>";
				name += "<a href='/'>back to root</a>";
				break;
			default:
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + number);
			}
		}
		return ResponseEntity.ok(name);
	}
}
