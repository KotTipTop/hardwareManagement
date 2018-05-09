package pl.inz.cymerman.app.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pl.inz.cymerman.app.model.Equipment;

import pl.inz.cymerman.app.repository.EquipmentRepository;

@RunWith(MockitoJUnitRunner.class)
public class EquipmentServiceImplTest {
	@Mock
	private EquipmentRepository repository;

	@InjectMocks
	private EquipmentServiceImpl equipmentService;

	// list
	@Test
	public void shouldGetEquipmentList() {
		// given
		Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Equipment(), new Equipment()));
		// when
		List<Equipment> equipment = equipmentService.findAll();
		// then
		Assert.assertEquals(2, equipment.size());
	}
	//get one
	@Test
	public void shouldGetEquipmentById() {
		//given
		Mockito.when(repository.findOne(1L)).thenReturn(new Equipment());
		//when
		Equipment d = equipmentService.findOne(1L);
		//then
		Assert.assertEquals(new Equipment(), d);
	}
	//save
	@Test
	public void shouldSaveNewEquipment() {
		//given
		Equipment equipmentOne = new Equipment();
		Mockito.when(equipmentService.save(Mockito.any(Equipment.class))).thenReturn(equipmentOne);
		//when
		Equipment d = equipmentService.save(equipmentOne);
		//then
		Assert.assertEquals(equipmentOne, d);
	}
	//delete
	@Test
	public void shouldDeleteEquipment() {
		//given
		Equipment d = new Equipment(1L,true);
		Mockito.when(repository.findOne(Mockito.anyLong())).thenReturn(d);
		
		//then
		//times nie działa o co chodzi? 
		Mockito.verify(repository).findOne(1L);
        Mockito.verify(repository).delete(d);
        Mockito.verifyNoMoreInteractions(repository);
	}
}
