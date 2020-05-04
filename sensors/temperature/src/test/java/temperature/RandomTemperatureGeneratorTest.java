package temperature;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.Test;

public class RandomTemperatureGeneratorTest {

	@Test
	public void testGetTemperature() {
		RandomTemperatureGenerator generator = new RandomTemperatureGenerator();
		float temperature = generator.getTemperature();
		
		assertThat(temperature, greaterThanOrEqualTo(0.0f));
		assertThat(temperature, lessThanOrEqualTo(26.0f));
	}

}
