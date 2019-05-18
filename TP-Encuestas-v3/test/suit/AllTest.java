package suit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
	"cuestionario",
	"investigador",
	"opcion",
	"pregunta",
	"proyecto",
	"respuesta",
	"sistema"
}) 

public class AllTest {
}
