 package  net.is_bg.ltf.businessmodels.softuni.servicegroup;

 
 import java.util.List;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RestController;
 import com.example.demo.AppConstants;
 import controller.IController;
 
 
 @RestController
 public class ServicegroupController implements IController<Servicegroup> {
 
 	private static final String MAIN_PATH = "/service_group";
 	private static final ServicegroupService service = new ServicegroupService();
 	
 	
 	@GetMapping(MAIN_PATH + AppConstants.ID_PATH_PARAM)
 	public Servicegroup find( Long id) {
 		//System.out.println("Entered in find...");
 		return service.find(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.DELETE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Long delete( Long id) {
 		//System.out.println("Entered in delete...");
 		return service.delete(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.CREATE_SUB_PATH)
 	public Servicegroup create(Servicegroup obj) {
 		service.create(obj);
 		//System.out.println("Entered in create...");
 		return obj;
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.UPDATE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Servicegroup update(Servicegroup obj, Long id) {
 		//System.out.println("entered in update");
 		service.update(obj, id);
 		return obj;
 	}
 
 	@GetMapping(MAIN_PATH)
 	public List<Servicegroup> list(int page, int delta) {
 		//System.out.println("entered in list...");
 		return service.list(page, delta);
 	}
 }
