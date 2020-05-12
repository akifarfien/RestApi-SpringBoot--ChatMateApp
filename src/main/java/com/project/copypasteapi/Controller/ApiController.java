package com.project.copypasteapi.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.copypasteapi.Bean.CopyPasteBean;
import com.project.copypasteapi.Bean.UserData;
import com.project.copypasteapi.Exception.ApiException;
import com.project.copypasteapi.Repository.CopyPasteApiRerpository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/copypasteapi")
public class ApiController {

	@Autowired
	private CopyPasteApiRerpository repository;

	@GetMapping()
	public String dummy() {
		return "Hi there, This is a Rest api for a project application called SHARE-IT." + "\n"
				+ " TO use this API please contact Akif Arfien @akifarfien.";
	}

	@GetMapping("/{id}")
	public Optional<CopyPasteBean> getBean(@PathVariable("id") String id) {

		Optional<CopyPasteBean> bean = repository.findById(id);

		if (!(bean.isPresent())) {
			throw new ApiException("ID : " + id + " is not found");
		} else
			return bean;

	}

	@GetMapping("/admin/not-ForAll/list")
	public List<CopyPasteBean> say() {
		return repository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public CopyPasteBean createEntry(@RequestBody CopyPasteBean bean) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		bean.setDateandTime(dtf.format(now));

		UserData ud = new UserData();
		ud.setName(bean.getName());
		ud.setTextmssg(bean.getLastcontent());

		bean.getContentList().add(ud);

		if (bean.getUniqueCodeUrl().isEmpty()) {
			bean.setUniqueCodeUrl(generateString());
		}

		repository.save(bean);
		return bean;

	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public CopyPasteBean updateEntry(@RequestBody CopyPasteBean bean) {

		Optional<CopyPasteBean> dtoOptional = repository.findById(bean.getUniqueCodeUrl());

		if (!(dtoOptional.isPresent())) {

			throw new ApiException("ID : " + bean.getUniqueCodeUrl() + " is not found");
		} else {
			CopyPasteBean dto = dtoOptional.get();

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			dto.setDateandTime(dtf.format(now));
			dto.setLastcontent(bean.getLastcontent());

			UserData ud = new UserData();
			ud.setName(bean.getName());
			ud.setTextmssg(bean.getLastcontent());

			dto.getContentList().add(ud);

			repository.save(dto);
			return dto;
		}

	}

	@Scheduled(fixedDelay = 240000, initialDelay = 120000)
	private void deleteEntries() {

		System.out.println("I am from  Schedul Task");
		List<CopyPasteBean> list = new ArrayList<CopyPasteBean>();

		for (CopyPasteBean bean : repository.findAll()) {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime d = LocalDateTime.parse(bean.getDateandTime(), dtf);

			LocalDateTime d10 = d.plusMinutes(15); // 10

			String newTime = dtf.format(d10);

			LocalDateTime now = LocalDateTime.now();

			System.out.print(newTime);

			if (d10.isBefore(now)) {
				list.add(bean);

			}

		}

		if (!(list.isEmpty())) {
			repository.deleteAll(list);
		}
	}

	private static String generateString() {
		String uuid = UUID.randomUUID().toString();
		return uuid.substring(25);
	}
}
