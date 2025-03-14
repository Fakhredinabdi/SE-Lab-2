import random
import time

def simulate_sensor_data():
    """Simulates fetching sensor data from IoT devices."""
    # Simulate sensor data
    temperature = random.uniform(20.0, 30.0)  # temperature in Celsius
    humidity = random.uniform(40.0, 60.0)     # humidity in %
    light_level = random.randint(100, 800)    # light level in lumens
    
    return {
        "temperature": round(temperature, 2),
        "humidity": round(humidity, 2),
        "light_level": light_level
    }

def fetch_sensor_data(interval=5):
    """Fetches sensor data at specified intervals (in seconds)."""
    try:
        while True:
            data = simulate_sensor_data()
            print(f"Fetching sensor data...")
            print(f"Temperature: {data['temperature']} °C")
            print(f"Humidity: {data['humidity']} %")
            print(f"Light Level: {data['light_level']} lumens")
            print("-" * 30)
            
            # Wait for the next interval
            time.sleep(interval)
    except KeyboardInterrupt:
        print("Stopped fetching sensor data.")

# Set the data fetching interval to 10 seconds
fetch_sensor_data(interval=10)
