package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore primaryStore;
  private TorpedoStore secondaryStore;

  @BeforeEach
  public void init(){
    primaryStore = mock(TorpedoStore.class);
    secondaryStore = mock(TorpedoStore.class);
    this.ship = new GT4500(primaryStore, secondaryStore);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    //when(ship.fireTorpedo(FiringMode.SINGLE)).thenReturn(true);
    when(primaryStore.fire()).thenReturn(true);
    when(secondaryStore.fire()).thenReturn(true);

    // Act
    //boolean result = ship.fireTorpedo(FiringMode.SINGLE);
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(primaryStore, times(1)).fire();
    verify(secondaryStore, times(1)).fire();
    //assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    //when(ship.fireTorpedo(FiringMode.ALL)).thenReturn(true);
    when(primaryStore.fire()).thenReturn(true);
    when(secondaryStore.fire()).thenReturn(true);
    // Act
    //boolean result = ship.fireTorpedo(FiringMode.ALL);
    ship.fireTorpedo(FiringMode.ALL);

    // Assert
    //verify(ship, times(1)).fireTorpedo(FiringMode.ALL);
    //assertEquals(true, result);
    verify(primaryStore, times(1)).fire();
    verify(secondaryStore, times(1)).fire();
  }

}
