package rest.servlets;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import rest.dto.SellersDto;
import rest.services.SellersService;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class SellersServlet {
	private final SellersService sellersService = new SellersService();
	private final Gson jsn = new Gson();
	@GetMapping("/sellers/{id}")
	public String find(@PathVariable Integer id) throws IOException {
		return jsn.toJson(sellersService.find(id));
	}
	@GetMapping("/sellers")
	public String find() throws IOException {
		StringBuilder str=new StringBuilder();
		sellersService.find().forEach(e -> {
			str.append(jsn.toJson(e));
			str.append("\n\n");
		});
		return str.toString();
	}
	@PostMapping("/sellers")
	public String save(@RequestBody SellersDto sellersDto) throws IOException {
		return "saved with id: " + sellersService.save(sellersDto);
	}
	@PutMapping("/sellers")
	public String update(@RequestBody SellersDto sellersDto) throws IOException, SQLException {
		return "updated under id: " + sellersService.update(sellersDto);
	}

	@DeleteMapping("/sellers")
	public String delete(@RequestBody SellersDto sellersDto) throws IOException {
		return "deleted under id: " + sellersService.delete(sellersDto);
	}
}
