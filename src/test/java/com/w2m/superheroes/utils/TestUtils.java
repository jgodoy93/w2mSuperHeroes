package com.w2m.superheroes.utils;

import java.util.ArrayList;
import java.util.List;

import com.w2m.superheroes.entity.SuperHeroeEntity;
import com.w2m.superheroes.model.SuperHeroe;

public final class TestUtils {

	private static final Long ID = 1L;
	private static final Long ID_2 = 2L;
	private static final Long ID_3 = 3L;
	private static final String IDS = "1";
	private static final String IDS_2 = "2";
	private static final String IDS_3 = "3";
	private static final String NAME = "TestSuperHeroe";
	private static final String NAME_2 = "TestSuperHeroe2";
	private static final String NAME_3 = "Manolito Testea";
	private static final String COMMENT = "Un heroe de mentira";
	private static final String COMMENT_2 = "Otro heroe de mentira";
	private static final String COMMENT_3 = "El verdadero heroe";

	public static SuperHeroe buildSuperHeroe() {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(IDS);
		superHeroe.setName(NAME);
		superHeroe.setComment(COMMENT);
		return superHeroe;
	}

	public static SuperHeroe buildSuperHeroe2() {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(IDS_2);
		superHeroe.setName(NAME_2);
		superHeroe.setComment(COMMENT_2);
		return superHeroe;
	}

	public static SuperHeroe buildSuperHeroe3() {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(IDS_3);
		superHeroe.setName(NAME_3);
		superHeroe.setComment(COMMENT_3);
		return superHeroe;
	}

	public static List<SuperHeroe> buildListSuperHeroeDTO() {
		List<SuperHeroe> list = new ArrayList<>();
		list.add(buildSuperHeroe());
		list.add(buildSuperHeroe2());
		list.add(buildSuperHeroe3());
		return list;
	}

	public static SuperHeroeEntity buildSuperHeroeEntity() {
		return SuperHeroeEntity.builder().id(ID).name(NAME).comment(COMMENT).build();
	}

	public static SuperHeroeEntity buildSuperHeroeEntity2() {
		return SuperHeroeEntity.builder().id(ID_2).name(NAME_2).comment(COMMENT_2).build();

	}

	public static SuperHeroeEntity buildSuperHeroeEntity3() {
		return SuperHeroeEntity.builder().id(ID_3).name(NAME_3).comment(COMMENT_3).build();
	}

	public static List<SuperHeroeEntity> buildListSuperHeroes() {
		List<SuperHeroeEntity> list = new ArrayList<>();
		list.add(buildSuperHeroeEntity());
		list.add(buildSuperHeroeEntity2());
		list.add(buildSuperHeroeEntity3());
		return list;
	}

}
