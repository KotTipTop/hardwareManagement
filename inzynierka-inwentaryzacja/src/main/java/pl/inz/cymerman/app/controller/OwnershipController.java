package pl.inz.cymerman.app.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import pl.inz.cymerman.app.converter.ObjectConverter;
import pl.inz.cymerman.app.dto.OwnershipAssignFormDTO;
import pl.inz.cymerman.app.dto.OwnershipReturnFormDTO;
import pl.inz.cymerman.app.model.Ownership;
import pl.inz.cymerman.app.model.User;
import pl.inz.cymerman.app.service.OwnershipService;

@Controller
@RequestMapping("/ownership")
public class OwnershipController {

	private final ObjectConverter converter;
	private final OwnershipService ownershipService;

	@Autowired
	public OwnershipController(ObjectConverter converter, OwnershipService ownershipService) {
		this.converter = converter;
		this.ownershipService = ownershipService;
	}

	@PostMapping("/return")
	public String giving(ModelMap model, @ModelAttribute("ReturnNewModal") OwnershipReturnFormDTO o) {
		Ownership o1 = ownershipService.ownershipByUserIdAndAllocationDate(o.getEquipmentId());
		o1.setAllocationEndDate(o.getAllocationEndDate());
		ownershipService.save(o1);
		return "redirect:/equipment/";

	}

	@PostMapping("/assign")
	public String assign(ModelMap model, @ModelAttribute("AssignNewModal") OwnershipAssignFormDTO o) {
		Ownership ownership = converter.convert(o, Ownership.class);
		ownershipService.save(ownership);
		return "redirect:/equipment/";

	}

	@GetMapping("/givingReport")
	public void givingReport(ModelMap model, @Param("id") Long id, HttpServletResponse response) throws IOException, DocumentException {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PdfReader reader = new PdfReader("src/main/resources/pusty.pdf");
		Ownership o = ownershipService.findOne(id);
		String nameOfFile = o.getOwner().getName() + " " + o.getOwner().getSurname() + " - protokół powierzenia";
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(reader, b);
		AcroFields form = stamper.getAcroFields();
		form.setField("location", o.getLocation().getName());
		form.setField("date", o.getAllocationStartDate().toString());
		form.setField("category", o.getEquipment().getCategory().getName());
		form.setField("fullName", o.getOwner().getName() + " " + o.getOwner().getSurname());
		form.setField("equipmentModelName", o.getEquipment().getManufacturer() + " " + o.getEquipment().getModel());
		form.setField("equipmentSerialNumber", o.getEquipment().getSerialNumber());
		form.setField("user", o.getOwner().getName() + " " + o.getOwner().getSurname());
		form.setField("admin", user.getName() + " " + user.getSurname());
		stamper.setFormFlattening(true);
		stamper.close();
		reader.close();
		InputStream baos = new ByteArrayInputStream(b.toByteArray());
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + nameOfFile + ".pdf");
		OutputStream os = response.getOutputStream();
		byte buffer[] = new byte[8192];
		int bytesRead;
		while ((bytesRead = baos.read(buffer)) != -1) {
			os.write(buffer, 0, bytesRead);
		}

		b.flush();
		b.close();
		baos.close();

	}
	@GetMapping("/passingReport")
	public void passingReport(ModelMap model, @Param("id") Long id, HttpServletResponse response) throws IOException, DocumentException {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PdfReader reader = new PdfReader("src/main/resources/zdanie.pdf");
		Ownership o = ownershipService.findOne(id);
		String nameOfFile = o.getOwner().getName() + " " + o.getOwner().getSurname() + " - protokół zdania";
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(reader, b);
		AcroFields form = stamper.getAcroFields();
		form.setField("location", o.getLocation().getName());
		form.setField("date", o.getAllocationEndDate()!=null ? o.getAllocationEndDate().toString():null);
		form.setField("category", o.getEquipment().getCategory().getName());
		form.setField("equipmentModelName", o.getEquipment().getManufacturer() + " " + o.getEquipment().getModel());
		form.setField("equipmentSerialNumber", o.getEquipment().getSerialNumber());
		form.setField("user", o.getOwner().getName() + " " + o.getOwner().getSurname());
		form.setField("admin", user.getName() + " " + user.getSurname());
		stamper.setFormFlattening(true);
		stamper.close();
		reader.close();
		InputStream baos = new ByteArrayInputStream(b.toByteArray());
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + nameOfFile + ".pdf");
		OutputStream os = response.getOutputStream();
		byte buffer[] = new byte[8192];
		int bytesRead;
		while ((bytesRead = baos.read(buffer)) != -1) {
			os.write(buffer, 0, bytesRead);
		}

		b.flush();
		b.close();
		baos.close();

	}
}
