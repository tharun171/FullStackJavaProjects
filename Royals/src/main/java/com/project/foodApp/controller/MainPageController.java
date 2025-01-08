package com.project.foodApp.controller;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project.foodApp.BusinessBeans.AddDelivery;
import com.project.foodApp.BusinessBeans.CartVariables;
import com.project.foodApp.BusinessBeans.Item;
import com.project.foodApp.BusinessBeans.UserBean;
import com.project.foodApp.Entities.UserEntityCart;
import com.project.foodApp.Service.CartService;
import com.project.foodApp.Service.MainResourceService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@Controller
@SessionAttributes({"accountDetails","itemsInCart","username","userId","items","allItems","textData","userCartItems"})
public class MainPageController {

	ModelAndView mav;
	UserBean userDetails = null;
	
	@Autowired
	MainResourceService service;
	
	@Autowired
	CartService cartService;
	
	
	int count = 0;
	
	@GetMapping("/{userId}/main")
	public ModelAndView header(@PathVariable("userId") int id,@ModelAttribute("accountDetails") UserBean accountDetails,
			@ModelAttribute("username") String username,@ModelAttribute("userId") int userId,
			HttpServletResponse response
			,@ModelAttribute("itemsInCart") int itemsInCart,@ModelAttribute("items") String items) throws Exception
	{
		 response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	     response.setHeader("Pragma", "no-cache");
	     response.setHeader("Expires", "0");
		System.out.println("inside main controller");
		mav = new ModelAndView();
		System.out.println("user id is "+id);
		System.out.println("username is "+username);
		System.out.println("size of cart "+itemsInCart);
		System.out.println("account Details "+accountDetails.toString());
		System.out.println("ids of items to add "+items);
		
		if(count==0)
		{
			System.out.println("items "+items);
		}
		else
		{
			items = "";
			System.out.println(items);
		}
		count = count + 1;
		List<Integer> l = new ArrayList<>();
		String str  = "";
		for(int i=0;i<items.length();i++)
		{
			char c = items.charAt(i);
			int value = items.charAt(i);
			if(value>=48 && value<=57)
			{
				str=str+c;
				if(str.length()==6)
				{
					Integer val  = Integer.parseInt(str);
					l.add(val);
					str="";
				}
			}
		}
		List<Integer> existlist = cartService.getCartItems(userId);
		for (Integer e: existlist) {
			l.add(e);
		}
		System.out.println("list to added "+l);
		mav.addObject("items", l);
		mav.setViewName("mainPage");
		return mav;
	}
	
	@GetMapping({"/accountDetails","/{UserId}/accountDetails"})
	public ModelAndView accountDetails(@ModelAttribute("accountDetails") UserBean accountDetails)
	{
		mav = new ModelAndView();
		mav.setViewName("accountDetails");
		System.out.println("userdetails "+accountDetails);
		mav.addObject("accountDetailsNew",accountDetails);
		System.out.println(accountDetails.toString());
		return mav;
	}
	
	@PostMapping("/updateAccountDetails")
	public UserBean updateAccountDetails(@ModelAttribute("accountDetailsNew") UserBean newDetails)
	{
		System.out.println("inside updation");
		System.out.println(newDetails.toString());
		return newDetails;
	}
	
	
	//@ModelAttribute("items") String items,
	@GetMapping({"/cart"})
	@ModelAttribute("cartVariables")
	public ModelAndView openCart(
			@ModelAttribute("textData") List<Integer> textData,
			@ModelAttribute("userId") Integer userId,
			@ModelAttribute("items") String items,
			@ModelAttribute("allItems")List<List<Item>> allItems,
			@ModelAttribute("cartVariables") CartVariables cartVariables,
			HttpSession sess) throws Exception
	{
		System.out.println("inside /cart api");
		mav = new ModelAndView();
		List<Integer> updatedList  = cartService.getCartItems(userId);
	    List<Integer> textData1 = textData;
		System.out.println("list previous before updation"+updatedList);
		if(textData1!=null && textData1.size()>0 )
		{
			for (Integer item : textData1) {
				if(updatedList.contains(item)!=true)
				{
					updatedList.add(item);
				}
			}
		}
		List<Integer> list = cartService.updateCart(userId,updatedList);
		System.out.println("list "+list);
		System.out.println("updatedList "+updatedList);
		int sizeOfCart = cartService.ItemsInCart(userId);
		mav.addObject("itemsInCart",sizeOfCart);
		System.out.println("size of cart after updation "+sizeOfCart);
		System.out.println("updated list "+updatedList);
		List<Item> userSelectedList = new ArrayList<Item>();
		List<List<Item>> allItems2 = allItems;
		for (Integer item :updatedList) {
			System.out.println(item);
			for(int i=0;i<allItems.size();i++)
			{
				//System.out.println(allItems.get(i));
				List<Item> li = allItems.get(i);
				for(int j=0;j<li.size();j++)
				{
					Integer id = li.get(j).getFoodId();
					if(item.equals(id))
					{
						System.out.println("matched");
						System.out.println(li.get(j));
						Item abc = li.get(j);
						userSelectedList.add(abc);
					}
				}
			}
		}
		System.out.println("updated list "+updatedList);
		System.out.println("user selected items "+userSelectedList);
		mav.addObject("userSelectedItems",userSelectedList);
		//stored in session
		sess.setAttribute("userCartItems",userSelectedList);
		String address = cartService.getAddress(userId);
		if(address==null)
		{
			address  = "not added address";
		}
		System.out.println("address "+address);
		mav.addObject("address", address);
		System.out.println("cart variables "+cartVariables);
		mav.addObject("cartVariables",cartVariables);
		mav.setViewName("cart");
		return mav;
		//update cart details using daoImpl
	}
	
	@GetMapping("/invoice")
	public ModelAndView invoice(
			@RequestParam MultiValueMap<String,String> map,
			@RequestParam(name = "deliverytip") Float deliverytip,
			@RequestParam(name="total") Float total,
			@ModelAttribute("cartVariables") CartVariables cartVariables,
			@ModelAttribute("allItems") List<List<Item>> allItems,
			@ModelAttribute("accountDetails") UserBean accountDetails,HttpSession sess) throws Exception
	{
		MultiValueMap<String,String> queryParams = map;
		System.out.println(queryParams.toString());
		
		List<String> items = new ArrayList<>();
		List<String> Quantity = new ArrayList<>();
		
		Set<String> keyNames = queryParams.keySet();
		for (String key : keyNames) {
		    System.out.println("Key: " + key);
		    items.add(key);
		    System.out.println(queryParams.get(key).get(0));
		    String a = queryParams.get(key).get(0).toString();
		    Quantity.add(a);
		}
	    
		System.out.println("inside invoice");
		System.out.println("idQuan "+map);
		System.out.println("cart variables "+cartVariables);
		System.out.println("delivery tip "+deliverytip);
		System.out.println("total "+total);
		System.out.println("account Details "+accountDetails);
		List<List<Item>> allItems2 = allItems;
		List<Integer> updatedList  = cartService.getCartItems(accountDetails.getUserId());
		List<Integer> list = cartService.updateCart(accountDetails.getUserId(),updatedList);
		List<Item> userSelectedList = new ArrayList<>();
		for (Integer item :updatedList) {
			System.out.println(item);
			for(int i=0;i<allItems2.size();i++)
			{
				//System.out.println(allItems.get(i));
				List<Item> li = allItems2.get(i);
				//System.out.println(li);
				for(int j=0;j<li.size();j++)
				{
					Integer id = li.get(j).getFoodId();
					if(item.equals(id))
					{
						System.out.println("matched");
						System.out.println(li.get(j));
						Item abc = li.get(j);
						userSelectedList.add(abc);
					}
				}
			}
		}
		System.out.println("cart items "+userSelectedList);
		System.out.println(userSelectedList);
		System.out.println(items);
		System.out.println(Quantity);
		List<Integer> totalPrice = new ArrayList<>();
		//no need of adding coz we already got the total amount as total
		double totalPriceAllAdded = 0;
		for(int i=0;i<items.size()-2;i++)
		{
			System.out.println(userSelectedList.get(i).getTitle());
			System.out.println(items.get(i));
			for(int j=0;j<items.size();j++)
			{
				if(userSelectedList.get(i).getTitle().equals(items.get(j)))
				//if(items.get(i).equals(userSelectedList.get(i).getTitle()))
				{
					int price = userSelectedList.get(i).getPrice();
					int quantity = Integer.parseInt(Quantity.get(i));
					totalPriceAllAdded = totalPriceAllAdded + (price*quantity);
					totalPrice.add(price*quantity);
				}
			}
		}
	
		
		System.out.println(totalPrice);
		//getting address
		String address = cartService.getAddress(accountDetails.getUserId());
		System.out.println(address);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		
		
		mav = new ModelAndView();
		mav.addObject("items",items);
		mav.addObject("quantity",Quantity);
		mav.addObject("totalPrice", totalPrice);
		mav.addObject("subTotal", totalPriceAllAdded);
		mav.addObject("address", address);
		mav.addObject("date",strDate);
		//total price after adding everything
		mav.addObject("total",total);
		mav.addObject("deliveryTip",deliverytip);
		mav.setViewName("invoice");
		mav.addObject("cartVaraibles",cartVariables);
		mav.addObject("accountDetails",accountDetails);
		mav.addObject("userSelectedList", userSelectedList);
		return mav;
	}
	
	@GetMapping({"/usercart"})
	public ModelAndView openCart(
			@ModelAttribute("userId") Integer userId,@ModelAttribute("items") String items,
			@ModelAttribute("allItems")List<List<Item>> allItems) throws Exception
	{
		System.out.println("inside /cart api");
		mav = new ModelAndView();
		List<Integer> updatedList  = cartService.getCartItems(userId);
		List<Integer> list = cartService.updateCart(userId,updatedList);
		System.out.println("list "+list);
		System.out.println("updatedList "+updatedList);
		int sizeOfCart = cartService.ItemsInCart(userId);
		mav.addObject("itemsInCart",sizeOfCart);
		System.out.println("size of cart after updation "+sizeOfCart);
		System.out.println("updated list "+updatedList);
		List<Item> userSelectedList = new ArrayList<Item>();
		List<List<Item>> allItems2 = allItems;
		for (Integer item :updatedList) {
			System.out.println(item);
			for(int i=0;i<allItems.size();i++)
			{
				//System.out.println(allItems.get(i));
				List<Item> li = allItems.get(i);
				for(int j=0;j<li.size();j++)
				{
					Integer id = li.get(j).getFoodId();
					if(item.equals(id))
					{
						System.out.println("matched");
						System.out.println(li.get(j));
						Item abc = li.get(j);
						userSelectedList.add(abc);
					}
				}
			}
		}
		System.out.println("updated list "+updatedList);
		System.out.println("user selected items "+userSelectedList);
		mav.addObject("userSelectedItems",userSelectedList);
		String address = cartService.getAddress(userId);
		if(address==null)
		{
			address  = "not added address";
		}
		System.out.println("address "+address);
		mav.addObject("address", address);
		mav.setViewName("cart");
		return mav;
		//update cart details using daoImpl
	}
	
	
	@GetMapping("/updatedCart")
	public ModelAndView updatedCart(
			@ModelAttribute("userId") Integer userId,
			@ModelAttribute("allItems") List<List<Item>> allItems,
			@ModelAttribute("cartVariables") CartVariables cartVariables,
			HttpSession sess) throws Exception
	{
		System.out.println(userId);
		mav = new ModelAndView();
		System.out.println("inside updated cart");
		List<Integer> updatedList = cartService.getCartItems(userId);
		System.out.println("items from cart in db "+updatedList);
		int sizeOfCart = updatedList.size();
		System.out.println(sizeOfCart);
		mav.addObject("itemsInCart",sizeOfCart);
		System.out.println("updated list is "+updatedList);
		List<Integer> list = cartService.updateCart(userId,updatedList);
		//creating new list
		List<Item> userSelectedList = new ArrayList<Item>();
		//getting all items in menu
		List<List<Item>> allItems2 = allItems;
		for (Integer item :updatedList) {
			System.out.println(item);
			for(int i=0;i<allItems2.size();i++)
			{
				//System.out.println(allItems.get(i));
				List<Item> li = allItems2.get(i);
				//System.out.println(li);
				for(int j=0;j<li.size();j++)
				{
					Integer id = li.get(j).getFoodId();
					if(item.equals(id))
					{
						System.out.println("matched");
						System.out.println(li.get(j));
						Item abc = li.get(j);
						userSelectedList.add(abc);
					}
				}
			}
		}
		mav.addObject("userSelectedItems",userSelectedList);
		mav.setViewName("cart");
		sess.setAttribute("userCartItems",userSelectedList);
		String address = cartService.getAddress(userId);
		if(address==null)
		{
			address  = "not added address";
		}
		System.out.println("address "+address);
		mav.addObject("address", address);
		System.out.println("cart variables "+cartVariables);
		mav.addObject("cartVariables",cartVariables);
		mav.setViewName("cart");
		return mav;
		
	}
	
	@GetMapping({"/cart/removeItem","updatedCart/removeItem"})
	public ModelAndView removeItem(@RequestParam String id,
			@ModelAttribute("userId") int userId,
			HttpServletRequest req) throws Exception
	{
		System.out.println("food id is "+id);
		Integer idToRemove = Integer.parseInt(id);
		System.out.println("userId got from sessionAttributes "+userId);
		List<Integer> updatedList = cartService.getCartItems(userId);
		List<Integer> updated = cartService.removeItem(userId,idToRemove, updatedList);
		System.out.println(updated);
		String newUrl = req.getContextPath()+"/updatedCart";
		System.out.println("new url redirected is "+newUrl);
		return new ModelAndView(new RedirectView(newUrl));
		//return new ResponseEntity<String>(id.toString(),HttpStatus.OK);
	}
	
	
	@ModelAttribute("allItems")
	public List<List<Item>> getAll() throws Exception
	{
		List<List<Item>> l = new ArrayList<>();
		List<Item> breakfast = service.getBreakfast();
		List<Item> pureVeg = service.getPureVeg();
		List<Item> refreshments = service.getRefreshments();
		List<Item> starters = service.getStarters();
		List<Item> pureNonveg = service.getPureNonVeg();
		List<Item> desserts = service.getDesserts();
		List<Item> specials = service.getRoyalSpecials();
		l.add(refreshments);
		l.add(starters);
		l.add(breakfast);
		l.add(pureVeg);
		l.add(pureNonveg);
		l.add(desserts);
		l.add(specials);
		return l;
	}
	
	//this is not used in the application don't FReak out
	@ModelAttribute("ids")
	public List<String> ids() throws Exception
	{
		List<String> l = new ArrayList<>();
		l.add("Refreshements");
		l.add("Starters");
		l.add("Breakfast");
		l.add("PureVeg");
		l.add("pureNonveg");
		l.add("desserts");
		l.add("specials");
		return l;
	}
	
	
	@GetMapping("/delivery")
	public ModelAndView delivery(@ModelAttribute("Delivery") AddDelivery delivery,
			@ModelAttribute("userId") Integer userId) throws Exception
	{
		mav = new ModelAndView();
		mav.setViewName("Delivery");
		mav.addObject("Delivery",new AddDelivery());
		String allAddress = cartService.getAllAddress(userId);
		List<String> allAddressList1 = new ArrayList<>();
		if(allAddress==null)
		{
			allAddressList1.clear();
		}
		System.out.println("all addresses "+allAddress);
		mav = new ModelAndView();
		String str = "";
		String[] add = allAddress.split("&");
		System.out.println(add.length);
//		for(int i=0;i<allAddress.length();i++)
//		{
//			char c =  allAddress.charAt(i);	
//			if(c!='&')
//			{
//				str = str + c;
//			}
//			if(c=='&')
//			{
//				//4 items 0,1,2,3
//				if(allAddressList1.size()<=3 && allAddressList1.contains(str)!=true)
//				{
//					allAddressList1.add(str.trim());
//				}
//				str="";
//			}
//			//System.out.println(allAddressList1.size());
//		}
		for(String a:add)
		{
			allAddressList1.add(a);
		}
		System.out.println(allAddressList1.size());
		mav.addObject("allAddressList",allAddressList1);
		if(allAddressList1.size()>=4)
		{
			System.out.println("inside if");
			mav.addObject("failuremessage","only 4 addresses to add");
			mav.addObject("listMessage1","maximum limit exceeded only 4 addresses can be stored");
			mav.addObject("listMessage2","Delete One to add One");
		}
		else
		{
			if(delivery.getPincode()!=null)
			{
				mav.addObject("successmessage","Added");
			}
		}
		System.out.println("all address list "+allAddressList1);
		mav.setViewName("Delivery");
		return mav;
	}
	
	
	@GetMapping("/AddDeliveryAddress")
	public ModelAndView addDelivery(@ModelAttribute("Delivery") AddDelivery delivery,
			@ModelAttribute("userId") Integer userId) throws Exception
	{
		mav = new ModelAndView();
		mav.setViewName("Delivery");
		System.out.println("inside add Delivery Address");
		System.out.println(delivery.toString());
		String address="";
		address = address + delivery.getDoorNo() + "," ;
		address = address + delivery.getStreet() + "," ;
		address = address + delivery.getCity() + "," ;
		address = address + delivery.getPincode() ;
		System.out.println(userId);
		List<String> allAddressList = new ArrayList<>();
		String allAddress = cartService.getAllAddress(userId);
		if(allAddress==null)
		{
			allAddressList.clear();
		}
		System.out.println("all addresses "+allAddress);
		mav = new ModelAndView();
		String str = "";
		for(int i=0;i<allAddress.length();i++)
		{
			char c =  allAddress.charAt(i);	
			if(c!='&')
			{
				str = str + c;
			}
			if(c=='&')
			{
				//4 items 0,1,2,3
				if(allAddressList.size()<=3 && allAddressList.contains(str)!=true)
				{
					allAddressList.add(str.trim());
				}
				str="";
			}
		}
		if(allAddressList.size()<4)
		{
			String addressAdded = cartService.addAddress(userId, address);
			mav.addObject("message","Address Added");
			allAddressList.add(address);
		}
		else
		{
			mav.addObject("message","Address limit exceeded");
		}
		mav.setViewName("Delivery");
		mav.addObject("allAddressList",allAddressList);
		if(allAddressList.size()>=4)
		{
			mav.addObject("listMessage1","maximum limit exceeded only 4 addresses can be stored");
			mav.addObject("listMessage2","Delete One to add One");
		}
		return new ModelAndView("redirect:"+"/delivery");
	}
	
	@Autowired
	private HttpSession session;

	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        // Get the current session, or null if there is no session
        System.out.println(session.getCreationTime());
        System.out.println(session.getId());
        if (session != null) {
            // Invalidate the session (log out the user)
            session.invalidate();
        }

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        // Redirect to the login page or any other page after logout
        return "redirect:/";
    }
	
	@GetMapping("/removeAdd")
	public ModelAndView removeAddress(@RequestParam Integer index,@ModelAttribute("userId") Integer userId) throws Exception
	{
		System.out.println("inside reomve address");
		System.out.println("id "+index);
		List<String> allAddressList1 = new ArrayList<>();
		String allAddress  = cartService.getAllAddress(userId);
		System.out.println("all address "+allAddress);
		String str = "";
		for(int i=0;i<allAddress.length();i++)
		{
			char c = allAddress.charAt(i);
			if(c!='&')
			{
				System.out.println(c);
				str = str + String.valueOf(c);
			}
			if(c=='&')
			{
				System.out.println("str ----------->"+str);
				allAddressList1.add(str);
				str="";
			}
		}
		System.out.println(allAddressList1);
		System.out.println("after removing "+allAddressList1.size());
		int index1 = index;
		allAddressList1.remove(index1);
		System.out.println("afer removing "+allAddressList1);
		String allAddress1 = "";
		for (String singleAddress : allAddressList1) {
			allAddress1 = allAddress1 + singleAddress + "&";
		}
		System.out.println("alladdress1 "+allAddress1);
		cartService.setAllAddress(userId, allAddress1);
		return new ModelAndView("redirect:"+"/delivery");
	}
	
	@GetMapping("/setPrimary")
	public void setPrimary(
			@RequestParam String address,
			@ModelAttribute("userId") Integer userId) throws Exception
	{
		System.out.println("set primary invoked");
		System.out.println(userId);
		//String primaryAddress = cartService.setAddress(userId, address);
		String primaryAddress = cartService.setAddress(userId,address);
		System.out.println("primary address set "+primaryAddress);
	}

}

	
//sending data seperately to each div
//	@ModelAttribute("breakfastList")
//	public List<Item> getBreakfastItems() throws Exception
//	{
//		return service.getBreakfast();
//	}
//	@ModelAttribute("pureVegList")
//	public List<Item> getPureVegIems() throws Exception
//	{
//		return service.getPureVeg();
//	}
//	@ModelAttribute("refreshments")
//	public List<Item> getRefreshmentItems() throws Exception
//	{
//		return service.getRefreshments();
//	}
//	@ModelAttribute("starters")
//	public List<Item> getStarterItems() throws Exception
//	{
//		return service.getStarters();
//	}
