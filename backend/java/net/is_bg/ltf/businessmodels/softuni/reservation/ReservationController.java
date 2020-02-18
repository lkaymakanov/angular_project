 package  net.is_bg.ltf.businessmodels.softuni.reservation;

 
 import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RestController;
 import com.example.demo.AppConstants;
 import controller.IController;
import net.is_bg.ltf.businessmodels.softuni.service.Service;
 
 
 @RestController
 public class ReservationController implements IController<Reservation> {
 
 	private static final String MAIN_PATH = "/reservation";
 	private static final ReservationService service = new ReservationService();
 	
 	
 	@GetMapping(MAIN_PATH + AppConstants.ID_PATH_PARAM)
 	public Reservation find( Long id) {
 		//System.out.println("Entered in find...");
 		return service.find(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.DELETE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Long delete( Long id) {
 		//System.out.println("Entered in delete...");
 		return service.delete(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.CREATE_SUB_PATH)
 	public Reservation create(Reservation obj) {
 		service.create(obj);
 		//System.out.println("Entered in create...");
 		return obj;
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.UPDATE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Reservation update(Reservation obj, Long id) {
 		//System.out.println("entered in update");
 		service.update(obj, id);
 		return obj;
 	}
 
 	@GetMapping(MAIN_PATH)
 	public List<Reservation> list(int page, int delta) {
 		return service.list(page, delta);
 	}
 	
 	@GetMapping(MAIN_PATH + "/user" +  AppConstants.ID_PATH_PARAM)
 	public List<Reservation> forUser(@PathVariable Long id) {
 		//System.out.println("entered in update");
 		return service.forUser(id);
 	}
 	
 	/*@GetMapping(MAIN_PATH + "/group" +  AppConstants.ID_PATH_PARAM)
 	//@GetMapping(MAIN_PATH+"/user"+ AppConstants.ID_PATH_PARAM)
 	public List<Reservation> forUser(@PathVariable Long userId) {
 		return service.forUser(userId);
 	}*/
 }
