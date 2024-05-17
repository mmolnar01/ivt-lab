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
    when(primaryStore.fire(1)).thenReturn(true);
    when(secondaryStore.fire(1)).thenReturn(true);

    // Act
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    /*if (ship.wasPrimaryFiredLast) {
        verify(primaryStore, times(1)).fire(1);
    } else {
        verify(secondaryStore, times(1)).fire(1);
    }*/
    verify(primaryStore, times(1)).fire(1);
    verify(secondaryStore, times(0)).fire(anyInt());

  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(primaryStore.fire(1)).thenReturn(true);
    when(secondaryStore.fire(1)).thenReturn(true);

    // Act
    ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(primaryStore, times(1)).fire(1);
    verify(secondaryStore, times(1)).fire(1);
  }
  
  @Test
  public void fireTorpedo_All_Twice() {
      when(primaryStore.fire(1)).thenReturn(true);
      when(secondaryStore.fire(1)).thenReturn(true);

      ship.fireTorpedo(FiringMode.ALL);
      ship.fireTorpedo(FiringMode.ALL);

      verify(primaryStore, times(2)).fire(1);
      verify(secondaryStore, times(2)).fire(1);
  }


  public void fireTorpedo_Single_Twice(){
    // Arrange
    when(primaryStore.fire(1)).thenReturn(true);
    when(secondaryStore.fire(1)).thenReturn(true);

    // Act
    ship.fireTorpedo(FiringMode.SINGLE);
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    /*if (ship.wasPrimaryFiredLast) {
        verify(primaryStore, times(1)).fire(1);
    } else {
        verify(secondaryStore, times(1)).fire(1);
    }*/
    verify(primaryStore, times(1)).fire(1);
    verify(secondaryStore, times(1)).fire(1);

  }


}
