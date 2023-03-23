package com.w2m.superheroes.utils;

import java.util.ArrayList;
import java.util.List;

import com.w2m.superheroes.model.SuperHeroe;

public final class TestUtils {

	private static final String ID = "1";
	private static final String ID_2 = "2";
	private static final String ID_3 = "3";
	private static final String NAME = "TestSuperHeroe";
	private static final String NAME_2 = "TestSuperHeroe2";
	private static final String NAME_3 = "Manolito Testea";
	private static final String COMMENT = "Un heroe de mentira";
	private static final String COMMENT_2 = "Otro heroe de mentira";
	private static final String COMMENT_3 = "El verdadero heroe";

	public static SuperHeroe buildSuperHeroe() {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(ID);
		superHeroe.setName(NAME);
		superHeroe.setComment(COMMENT);
		return superHeroe;
	}

	public static SuperHeroe buildSuperHeroe2() {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(ID_2);
		superHeroe.setName(NAME_2);
		superHeroe.setComment(COMMENT_2);
		return superHeroe;
	}
	
	public static SuperHeroe buildSuperHeroe3() {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(ID_3);
		superHeroe.setName(NAME_3);
		superHeroe.setComment(COMMENT_3);
		return superHeroe;
	}
	
	public static List<SuperHeroe> buildListSuperHeroeDTO(){
		List<SuperHeroe> list = new ArrayList<>();
		list.add(buildSuperHeroe());
		list.add(buildSuperHeroe2());
		list.add(buildSuperHeroe3());
		return list;		
	}

	public static SuperHeroeEntity buildSuperHeroeEntity() {
		return new SuperHeroeEntity(ID, NAME, COMMENT);
	}

	public static SuperHeroeEntity buildSuperHeroeEntity2() {
		return new SuperHeroeEntity(ID_2, NAME_2, COMMENT_2);
	}

	public static SuperHeroeEntity buildSuperHeroeEntity3() {
		return new SuperHeroeEntity(ID_3, NAME_3, COMMENT_3);
	}

	public static List<SuperHeroeEntity> buildListSuperHeroes(){
		List<SuperHeroeEntity> list = new ArrayList<>();
		list.add(buildSuperHeroeEntity());
		list.add(buildSuperHeroeEntity2());
		list.add(buildSuperHeroeEntity3());
		return list;
	}

}
