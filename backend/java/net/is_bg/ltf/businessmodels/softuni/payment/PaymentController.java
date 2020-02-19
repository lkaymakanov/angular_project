 package  net.is_bg.ltf.businessmodels.softuni.payment;

 
 import java.util.List;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RestController;
 import com.example.demo.AppConstants;
 import controller.IController;
 
 
 @RestController
 public class PaymentController implements IController<Payment> {
 
 	private static final String MAIN_PATH = "/payment";
 	private static final PaymentService service = new PaymentService();
 	
 	
 	@GetMapping(MAIN_PATH + AppConstants.ID_PATH_PARAM)
 	public Payment find( Long id) {
 		//System.out.println("Entered in find...");
 		return service.find(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.DELETE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Long delete( Long id) {
 		//System.out.println("Entered in delete...");
 		return service.delete(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.CREATE_SUB_PATH)
 	public Payment create(Payment obj) {
 		service.create(obj);
 		//System.out.println("Entered in create...");
 		return obj;
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.UPDATE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Payment update(Payment obj, Long id) {
 		//System.out.println("entered in update");
 		service.update(obj, id);
 		return obj;
 	}
 	
 	@GetMapping(MAIN_PATH + "/user"+AppConstants.ID_PATH_PARAM)
 	public List<Payment> forUser(@PathVariable  Long id) {
 		//System.out.println("Entered in find...");
 		return service.forUser(id);
 	}
 
 	@GetMapping(MAIN_PATH)
 	public List<Payment> list(int page, int delta) {
 		//System.out.println("entered in list...");
 		return service.list(page, delta);
 	}
 }
