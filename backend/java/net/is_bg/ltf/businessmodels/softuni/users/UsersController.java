 package  net.is_bg.ltf.businessmodels.softuni.users;

 
 import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AppConstants;

import controller.IController;
import net.is_bg.ltf.jwt.JWTUtil;
import net.is_bg.ltf.jwt.TokenData;
 
 
 @RestController
 public class UsersController implements IController<Users> {
 
 	private static final String MAIN_PATH = "/users";
 	private static final UsersService service = new UsersService();
 	
 	@GetMapping(MAIN_PATH + AppConstants.ID_PATH_PARAM)
 	public Users find(Long id) {
 		//System.out.println("Entered in find...");
 		return service.find(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.DELETE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Long delete( Long id) {
 		//System.out.println("Entered in delete...");
 		return service.delete(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.CREATE_SUB_PATH)
 	public Users create(Users obj) {
 		service.create(obj);
 		//System.out.println("Entered in create...");
 		return obj;
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.UPDATE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Users update(Users obj, Long id) {
 		//System.out.println("entered in update");
 		service.update(obj, id);
 		return obj;
 	}
 
 	@GetMapping(MAIN_PATH)
 	public List<Users> list(int page, int delta) {
 		//System.out.println("entered in list...");
 		return service.list(page, delta);
 	}
 	
 	
 	@PostMapping(MAIN_PATH + AppConstants.VERIFY)
 	public boolean verifyToken(@RequestBody String body_sso, HttpServletResponse response) {
 		System.out.println(body_sso);
 		Users d=null;
 		 try {
			d = JWTUtil.getTokenData(body_sso, AppConstants.SECRET, Users.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		System.out.println(d);
 		return d!=null;
 	}
 	
 	@PostMapping(MAIN_PATH + AppConstants.LOGIN)
 	public boolean login(@RequestBody Users user, HttpServletResponse response) {
 		boolean res =  service.login(user.getEmail(), user.getPassword());
 		if(res) {
 			addTokenToResponse(user, response);
 		}
 		return res;
 	}
 	
 	@PostMapping(MAIN_PATH + AppConstants.LOGOUT)
 	public boolean logOut(HttpServletResponse response ) {
 		response.addCookie(new  Cookie("TOKEN", null));
 		return true;
 	}
 	
 	
 	@PostMapping(MAIN_PATH + AppConstants.AUTH)
 	public boolean auth(HttpServletRequest req,  HttpServletResponse response ) {
 		System.out.println("Entered in auth...");
 		return veifyToken(req);
 	}
 	
 	
 	
 	private static boolean veifyToken(HttpServletRequest req) {
 		Users u = getUserFromRequestToken(req);
 		System.out.println("user in request is " + u);
 		return u!=null;
 	}

 	
 	
 	private static Users getUserFromRequestToken(HttpServletRequest req) {
 		Cookie [] ck =  req.getCookies();
 		if(ck==null) return null;
 		Users u = null;
 		for(Cookie c : ck) {
 			if(c.getName().equals(AppConstants.TOKEN)) {
 			     try {
					u = JWTUtil.getTokenData(c.getValue(), AppConstants.SECRET ,Users.class);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 		}
 		return u;
 	}
 	
 	//private static helper methods
 	private static void addTokenToResponse(Users user, HttpServletResponse resp) {
 		String token = createToken(user);
 		addTokenToResponse(token, resp);
 	}
 	
 	
 	private static void addTokenToResponse(String token, HttpServletResponse resp) {
 		resp.addCookie(new  Cookie("TOKEN", token));
 	}
 	
 	private static String createToken(Users u) {
 		 return  JWTUtil.generateToken(u, AppConstants.SECRET, AppConstants.TOKEN_TTL_SECONDS);
 	}
 	
 }
