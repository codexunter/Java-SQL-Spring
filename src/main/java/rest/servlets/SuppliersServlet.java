package rest.servlets;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import rest.dto.SellersDto;
import rest.dto.SuppliersDto;
import rest.services.SuppliersService;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class SuppliersServlet {
	private final SuppliersService suppliersService = new SuppliersService();
	private final Gson jsn = new Gson();
	@GetMapping("/suppliers/{id}")
	public String find(@PathVariable Integer id) throws IOException {
		return jsn.toJson(suppliersService.find(id));
	}
	@GetMapping("/suppliers")
	public String find() throws IOException {
		StringBuilder str=new StringBuilder();
		suppliersService.find().forEach(e -> {
			str.append(jsn.toJson(e));
			str.append("\n\n");
		});
		return str.toString();
	}
	@PostMapping("/suppliers")
	public String save(@RequestBody SuppliersDto suppliersDto) throws IOException {
		return "saved with id: " + suppliersService.save(suppliersDto);
	}
	@PutMapping("/suppliers")
	public String update(@RequestBody SuppliersDto suppliersDto) throws IOException, SQLException {
		return "updated under id: " + suppliersService.update(suppliersDto);
	}

	@DeleteMapping("/suppliers")
	public String delete(@RequestBody SuppliersDto suppliersDto) throws IOException {
		return "deleted under id: " + suppliersService.delete(suppliersDto);
	}
}
