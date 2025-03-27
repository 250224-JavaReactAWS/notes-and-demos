package com.revature;

import com.revature.models.Creature;
import com.revature.models.Habitat;
import com.revature.services.CreatureService;
import com.revature.services.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataIntroApplication implements CommandLineRunner {

	private final HabitatService habitatService;

	private final CreatureService creatureService;

	@Autowired
    public SpringDataIntroApplication(HabitatService habitatService, CreatureService creatureService) {
        this.habitatService = habitatService;
        this.creatureService = creatureService;
    }


    public static void main(String[] args) {
		SpringApplication.run(SpringDataIntroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		This method run comes from the command line runner. Sometimes it's difficult to execute full code in a main
		method of a Spring application if you're not using something like Spring Web. So think of this as an alternative
		main method that gets executed when needed
		 */

		// Let's create a couple habitats
		Habitat forest = habitatService.createNewHabitat("forest");
		Habitat ocean = habitatService.createNewHabitat("ocean");


		// Let's add a few creatures
		creatureService.createCreature(new Creature("Toothless", "Dragon", 40, forest));
		creatureService.createCreature(new Creature("Smaug", "Dragon", 600, forest));
		creatureService.createCreature(new Creature("Minny", "Minotaur", 120, forest));
		creatureService.createCreature(new Creature("Dave", "Kraken", 500, ocean));
		creatureService.createCreature(new Creature("Scylla", "Kraken", 750, ocean));
		creatureService.createCreature(new Creature("John", "Leviathan", 900, ocean));

		// Let's display all of the creatures in the db
		// This prints every element
		System.out.println("All Creatures: ");
		creatureService.getAll().forEach(System.out::println);

		System.out.println("Creature #1: ");
		System.out.println(creatureService.getById(1));

		System.out.println("All of our Krakens");
		creatureService.getAllByCreatureType("Kraken").forEach(System.out::println);

		System.out.println("All creatures with 'o' in their name: ");
		creatureService.searchCreaturesByName("o").forEach(System.out::println);

		System.out.println("All creatures with 'o' in their name: ");
		creatureService.searchCreaturesByName2("o").forEach(System.out::println);

		System.out.println("All creatures in the forest older than 100 years old");
		creatureService.searchByHabitatAndMinAge("forest", 100).forEach(System.out::println);

		System.out.println("All creatures in the forest older than 100 years old");
		creatureService.searchByHabitatAndMinAge2("forest", 100).forEach(System.out::println);
	}

	/*
	Recall that Spring is a family of frameworks designed to create loosely coupled Java Applications. It leverages
	dependency injection to create instances of our classes and uses them as needed.

	Spring Data is a Spring project that has to do with storing data in all kinds of databases. Here we're going to
	leverage Spring Data JPA, which is a framework that leverages the JPA and Hibernate to help us store data in a
	relational database.

	JPA
		- Java Persistence API. It is a specification (think like an interface) that defines the ways to interact with classes
		and how to store them through various annotation
	Hibernate
		- ORM (Object Relational Mapper). This works as a translator between a Java Object and a record in a Relational
		Database. It acts as an implementation of the JPA. The does the actual operations against the database
	Spring Data
		- Framework built on top of Hibernate and JPA, it's designed to abstract things even further and make it even
		easier to work with a SQL database

	Recall before using Spring we used raw JDBC to create and send our Queries. We wanted to make sure we had CRUD
	methods for every single table. (Create -> Insert, Read -> Select All or Select One, Update -> Update,
	Delete ->Delete)
	 */

}
