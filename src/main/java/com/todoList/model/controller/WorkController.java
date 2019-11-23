package com.todoList.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todoList.model.service.WorkService;
import com.todoList.model.vo.Work;

@CrossOrigin(origins = { "*" })
@RestController
public class WorkController {

	private WorkService workService;

	@Autowired
	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}

	@GetMapping("/list/{flag}")
	public ResponseEntity<List<Work>> getList(@PathVariable String flag) throws Exception {
		List<Work> list = null;
		if (flag.equals("date")) {
			list = workService.getWorkListByDate();
		} else if(flag.equals("type")){
			list = workService.getWorkListByType();
		}
		return new ResponseEntity<List<Work>>(list, HttpStatus.OK);
	}
	

	@PostMapping("/work")
	public ResponseEntity<HashMap<String, String>> addWork(@RequestParam String name, @RequestParam String type,
			@RequestParam String content, @RequestParam String date) throws SQLException {
		// date는 자바8부터 지원되는 LocalDateTime 객체를 사용하면 되나, 프론트가 없기때문에 String으로 대체구현
		HashMap<String, String> hs = new HashMap<String, String>();

		Work w = new Work(name, type, content, date);

		if (workService.addWork(w)) {
			hs.put("code", "200");
			return new ResponseEntity<HashMap<String, String>>(hs, HttpStatus.OK);
		} else {
			hs.put("code", "300");
			return new ResponseEntity<HashMap<String, String>>(hs, HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/keroTest")
	public void test(HttpServletResponse response) throws IOException {
		response.getWriter().print("hello");
	}

	@DeleteMapping("/work/{no}")
	public ResponseEntity<Boolean> removeWork(@PathVariable int no) throws SQLException {
		return workService.deleteWork(no) ? new ResponseEntity<Boolean>(true, HttpStatus.OK)
				: new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

}
