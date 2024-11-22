package rest.servlets;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import rest.dto.FruitDto;
import rest.services.FruitService;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class FruitServlet {
	private final FruitService fruitService = new FruitService();
	private final Gson jsn = new Gson();
	@GetMapping("/fruit/{id}")
	public String find(@PathVariable Integer id) throws IOException {
		return jsn.toJson(fruitService.find(id));
	}
	@GetMapping("/fruit")
	public String find() throws IOException {
		StringBuilder str=new StringBuilder();
		fruitService.find().forEach(e -> {
			str.append(jsn.toJson(e));
			str.append("\n\n");
		});
		return str.toString();
	}
	@PostMapping("/fruit")
	public String save(@RequestBody FruitDto fruitDto) throws IOException {
		return "saved with id: " + fruitService.save(fruitDto);
	}
	@PutMapping("/fruit")
	public String update(@RequestBody FruitDto fruitDto) throws IOException, SQLException {
		return "updated under id: " + fruitService.update(fruitDto);
	}
	@DeleteMapping("/fruit")
	public String delete(@RequestBody FruitDto fruitDto) throws IOException {
		return "deleted under id: " + fruitService.delete(fruitDto);
	}
}
