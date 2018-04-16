package pl.inz.cymerman.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.inz.cymerman.app.model.Department.DepartmentBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	/*
	 * Baza sprz�tu. Role: Admin, Kierownik/Dyrektor, Pracownik Admin mo�e
	 * dodawa�/usuwa� sprz�t, dzia�y, realizowa� zamowienia, dodawac zamowienia,
	 * cofac zamowienia, dokumenty, akceptowac zdanie/powierzenie mienia. Ma podgl�d
	 * na wszystko. Ma podglad na sprzet uzytkownikow z przypisaniem i historia.
	 *
	 * Kierownik/Dyrektor - ma podglad na sprzet w swoim dziale i projektach ( 1
	 * dzia� wiele projektow). Moze podgladac pracownikow (1 dzia� wielu
	 * pracownikow). 1 pracownik moze pracowac w wielu projektach, ale tylko w
	 * jednym dziale. Projekt nie moze byc wspodzielony miedzy dzialy - moze?
	 * dopytac czy bedzie trudno.
	 *
	 * Moze akceptowac wnioski zakupowe (zamowienia) i akceptowac proponowany sprzet
	 * przez dzia� it ( jezeli jest na stanie). Moze tworzyc zamowienia, Moze zdawac
	 * sprzet.
	 *
	 * Pracownik szeregowy - moze wnioskowac zamowienia do przelozonego. Ma podglad
	 * na swoj sprzet, moze zdawac sprzet.
	 *
	 * 1 praacownik moze miec 1 sprzet danego typu. Jezeli chce dodatkowy to musi
	 * zdac poprzedni (akcept dzia�u IT).
	 *
	 * 
	 */
}
