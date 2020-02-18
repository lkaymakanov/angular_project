 package  net.is_bg.ltf.businessmodels.softuni.userdata;

 
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
import net.is_bg.ltf.businessmodels.softuni.users.Users;
import net.is_bg.ltf.jwt.JWTUtil;
 
 
 @RestController
 public class UserdataController implements IController<Userdata> {
 
 	private static final String MAIN_PATH = "/user_data";
 	private static final UserdataService service = new UserdataService();
 	
 	
 	@GetMapping(MAIN_PATH + AppConstants.ID_PATH_PARAM)
 	public Userdata find( Long id) {
 		//System.out.println("Entered in find...");
 		return service.find(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.DELETE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Long delete( Long id) {
 		//System.out.println("Entered in delete...");
 		return service.delete(id);
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.CREATE_SUB_PATH)
 	public Userdata create(Userdata obj) {
 		service.create(obj);
 		//System.out.println("Entered in create...");
 		return obj;
 	}
 
 	@PostMapping(MAIN_PATH + AppConstants.UPDATE_SUB_PATH + AppConstants.ID_PATH_PARAM)
 	public Userdata update(Userdata obj, Long id) {
 		//System.out.println("entered in update");
 		service.update(obj, id);
 		return obj;
 	}
 
 	@GetMapping(MAIN_PATH)
 	public List<Userdata> list(int page, int delta) {
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
 	public Userdata login(@RequestBody UserMailPass emailPass, HttpServletResponse response) {
 		Userdata d =  service.login(emailPass.getEmail(), emailPass.getPass());
 		if(d!=null) {
 			addTokenToResponse(d, response);
 		}else throw new RuntimeException("No such user pass...");
 		d.setPassword(null);
 		return d;
 	}
 	
 	@PostMapping(MAIN_PATH + AppConstants.LOGOUT)
 	public boolean logOut(HttpServletRequest req,  HttpServletResponse response ) {
 		System.out.println("log out ...");
 		eraseCookie(req, response);
 		return true;
 	}
 	
 	
 	@PostMapping(MAIN_PATH + AppConstants.AUTH)
 	public Userdata auth(HttpServletRequest req,HttpServletResponse response ) {
 		System.out.println("Entered in auth...");
 		Userdata d = getUserFromRequestToken(req);
 		if(d!=null) {d.setPassword(null); return d;}
 		throw new RuntimeException("No user logged..");
 	}
 	@PostMapping(MAIN_PATH + "/changepass"+ AppConstants.ID_PATH_PARAM)
 	public Userdata changePass(@RequestBody String pass, HttpServletRequest req, HttpServletResponse response) {
 		System.out.println("Entered in change pass...");
 		System.out.println(pass);
 		System.out.println("log out ...");
 		eraseCookie(req, response);
 		//invalidateCoockie(response);
 		//response.addCookie(new  Cookie("TOKEN", null));
 		return null;
 	}
 	
 	
 	
 	private static boolean veifyToken(HttpServletRequest req) {
 		Userdata u = getUserFromRequestToken(req);
 		System.out.println("user in request is " + u);
 		return u!=null;
 	}

 	
 	
 	private static Userdata getUserFromRequestToken(HttpServletRequest req) {
 		Cookie [] ck =  req.getCookies();
 		if(ck==null) return null;
 		Userdata u = null;
 		for(Cookie c : ck) {
 			
 			if(c.getName().equals(AppConstants.TOKEN)) {
 			     try {
 			    	System.out.println("Cookie max age is " + c.getMaxAge());
 			    	System.out.println("Cookie value is " + c.getValue());
					u = JWTUtil.getTokenData(c.getValue(), AppConstants.SECRET ,Userdata.class);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 		}
 		return u;
 	}
 	
 	//private static helper methods
 	private static void addTokenToResponse(Userdata user, HttpServletResponse resp) {
 		String token = createToken(user);
 		addTokenToResponse(token, resp);
 	}
 	
 	
 	
 	
 	
 	private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
 	    Cookie[] cookies = req.getCookies();
 	    if (cookies != null)
 	        for (Cookie cookie : cookies) {
 	            cookie.setValue("");
 	            cookie.setPath("/");
 	            cookie.setMaxAge(0);
 	            resp.addCookie(cookie);
 	        }
 	}
 	
 	
 	
 	private static void addTokenToResponse(String token, HttpServletResponse resp) {
 		resp.addCookie(new  Cookie("TOKEN", token));
 	}
 	
 	private static String createToken(Userdata u) {
 		 return  JWTUtil.generateToken(u, AppConstants.SECRET, AppConstants.TOKEN_TTL_SECONDS);
 	}
 }
