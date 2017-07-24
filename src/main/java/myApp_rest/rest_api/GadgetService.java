package myApp_rest.rest_api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/gadget")
public class GadgetService {

	public GadgetService() {
		// TODO Auto-generated constructor stub
		System.out.println("from GadgetServcie Class.....");
	}

	static ArrayList<Gadget> gadgetList = new ArrayList<Gadget>();
	static {

		Gadget g = new Gadget();
		g.setId(1);
		g.setBrand("Apple");
		g.setProduct("iPhone 6S");
		g.setDescription("Where every thing changed");
		g.setPrice(1100);
		gadgetList.add(g);

		Gadget g1 = new Gadget();
		g1.setId(2);
		g1.setBrand("Samsung");
		g1.setProduct("Tablet");
		g1.setDescription("Total flex-ability");
		g1.setPrice(230);
		gadgetList.add(g1);

	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gadget> viewGadgets() {
		return getAllGadgets();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gadget viewGadget(@PathParam(value = "id") int id) {

		return getGadgetByID(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Gadget addNew(Gadget gadget) {
		gadget.setId(gadgetList.size() + 1);
		gadgetList.add(gadget);
		return gadget;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Gadget change(Gadget gadget) {
		updateGadget(gadget);
		return getGadgetByID(gadget.getId());
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean remove(@PathParam(value = "id") int id) {

		Gadget gadget = null;
		Iterator<Gadget> iter = gadgetList.iterator();
		int index = -1;
		while (iter.hasNext()) {
			gadget = iter.next();
			if (gadget.getId() == id) {
				index++;
				break;
			}
		}
		if (index >= 0)
			return gadgetList.remove(gadget);
		return false;

	}

	private Gadget getGadgetByID(int id) {
		// TODO Auto-generated method stub
		Iterator<Gadget> iter = gadgetList.iterator();
		while (iter.hasNext()) {
			Gadget gadget = iter.next();
			if (gadget.getId() == id)
				return gadget;
		}
		return null;
	}

	private List<Gadget> getAllGadgets() {

		return gadgetList;
	}

	private void updateGadget(Gadget gadget) {
		// TODO Auto-generated method stub
		Iterator<Gadget> iter = gadgetList.iterator();
		int index = 0;
		while (iter.hasNext()) {
			Gadget gadget1 = iter.next();
			if (gadget1.getId() == gadget.getId()) {
				index++;
				break;
			}
		}
		gadgetList.add((index > 0) ? index - 1 : 0, gadget);
	}

}
