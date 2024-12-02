package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc.dao.StudentDao;
import springmvc.dto.StudentDto;

@Controller
public class Main {
	@Autowired
	StudentDao studentDao;

	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute StudentDto dto) {
		studentDao.insert(dto);
		return "data inserted Successfull";
	}

	@RequestMapping("/fid")
	public ModelAndView fetchById(@ModelAttribute StudentDto dto) {
		Object o = studentDao.fetchbyid(dto.getEmail());
		ModelAndView view = new ModelAndView("display.jsp");
		System.out.println(view.addObject("obj", o));
		return view;
	}

	@RequestMapping("/did")
	public ModelAndView deleteById(@ModelAttribute StudentDto dto) {
		studentDao.deleteById(dto.getEmail());
		Object o = studentDao.findAll();
		ModelAndView view = new ModelAndView("findAll.jsp");
		view.addObject("obj", o);
		return view;
	}

	@RequestMapping("/deleteAll")
	@ResponseBody
	public ModelAndView delete() {
		 studentDao.deleteAll();
		 Object o = studentDao.findAll();
			if (o != null) {
				ModelAndView view = new ModelAndView("findAll.jsp");
				view.addObject("obj", o);
				return view;
			} else {
				ModelAndView view = new ModelAndView("findAll.jsp");
				return view;
			}
	}

	@RequestMapping("/findAll")
	public ModelAndView fetch() {
		Object o = studentDao.findAll();
		if (o != null) {
			ModelAndView view = new ModelAndView("findAll.jsp");
			view.addObject("obj", o);
			return view;
		} else {
			ModelAndView view = new ModelAndView("findAll.jsp");
			return view;
		}
	}

	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute StudentDto dto) {
		studentDao.update(dto);
		System.out.println(dto);
		Object o = studentDao.findAll();
		ModelAndView view = new ModelAndView("findAll.jsp");
		view.addObject("obj", o);
		return view;
	}
}
