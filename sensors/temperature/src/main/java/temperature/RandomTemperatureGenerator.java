package temperature;

import java.time.Instant;
import java.util.Random;

public class RandomTemperatureGenerator implements TemperatureGenerator {
	private final Random generator = new Random(Instant.now().getEpochSecond());

	@Override
	public float getTemperature() {
		return (float) this.generator.nextInt(25) + this.generator.nextFloat();
	}

}
