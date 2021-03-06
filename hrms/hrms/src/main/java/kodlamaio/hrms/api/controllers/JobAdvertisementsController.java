package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {

		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>> getAllActive() {

		return this.jobAdvertisementService.findAllByIsActive();
	}

	@GetMapping("/getallactivesorted")
	public DataResult<List<JobAdvertisement>> getAllActiveSorted() {

		return this.jobAdvertisementService.findAllByIsActiveSorted();
	}

	@GetMapping("/getEmployerJobAdvertisement")
	public DataResult<List<JobAdvertisement>> findAllByIsActiveAndCompanyName(int id) {

		return this.jobAdvertisementService.findAllByIsActiveAndCompanyName(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisement) {

		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@PostMapping("/jobAdvertisementDisable")
	public DataResult<JobAdvertisement> setJobAdvertisementDisabled(int id) {

		return this.jobAdvertisementService.jobAdvertisementDisabled(id);
	}
	
	@GetMapping("/getOneById")
	public DataResult<List<JobAdvertisement>> getOneById(@RequestParam int id) {
		return this.jobAdvertisementService.getOneJobAds(id);
	}
}
