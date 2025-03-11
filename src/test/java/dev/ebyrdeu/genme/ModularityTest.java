package dev.ebyrdeu.genme;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTest {
	private final ApplicationModules modules = ApplicationModules.of(Application.class);

	@Test
	void verify() {
		modules.forEach(System.out::println);
		modules.verify();
	}

	@Test
	void docs() {
		new Documenter(modules).writeDocumentation();
	}

}
