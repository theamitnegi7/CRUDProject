package com.Project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Project.model.Student;
import com.Project.repo.StudentRepo;




@RestController
public class MyController {

	@Autowired
	StudentRepo Srepo;
	
	@GetMapping(value="/trial")
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	public String trial()
	{
		return "success its working";
	}
	
	@PostMapping(value = "/saveStudent")
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String, String> saveStudent(@RequestBody Student student)
	{
		
		HashMap<String, String> map=new HashMap<>();
		
		if(student.getStudentId()!=0)
		{
			map.put("Error", "Unknown field Student Id");
			return map;
		}
		Student s=Srepo.findByStudentId(student.getStudentId());
		if(s!=null)
		{
			map.put("message", "StudentID exists");
			return map;
		}
		
		try
		{
			Srepo.save(student);
		}
		catch (Exception e) {
			map.put("Error", ""+e);
			return map;
		}
		
		
		map.put("message", "datasaved");
		return map;
	}
	
	@PostMapping(value = "/viewStudent")
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	public HashMap<String,List<Student>> viewStudent()
	{
		HashMap<String,List<Student>> map=new HashMap<>();
		List<Student> data=(List<Student>) Srepo.findAll();
		if(!data.isEmpty())
		{
			map.put("data", data);
			return map;
		}
		map.put("No Data in table", null);
		return map;
	}
}
