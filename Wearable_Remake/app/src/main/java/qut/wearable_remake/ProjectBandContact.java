package qut.wearable_remake;

import com.microsoft.band.BandClient;
import com.microsoft.band.BandIOException;
import com.microsoft.band.sensors.BandContactEvent;
import com.microsoft.band.sensors.BandContactEventListener;
import com.microsoft.band.sensors.BandContactState;

/**
 * Created by Lok Sum (Moon) Lo on 9/12/2016.
 *
 * Class for Band contact state.
 */
class ProjectBandContact implements ProjectSensor {
    private final BandContactEventListener listener;
    private boolean worn = false;

    ProjectBandContact() {
        listener = new BandContactEventListener() {
            @Override
            public void onBandContactChanged(BandContactEvent event) {
                worn = (event.getContactState() == BandContactState.WORN);
            }
        };
    }

    /**
     * Unregisters the sensor's event listener.
     *
     * @param bandClient The BandClient whose event listener is unregistered.
     */
    @Override
    public void registerListener(BandClient bandClient) {
        try {
            bandClient.getSensorManager().registerContactEventListener(listener);
        } catch (BandIOException ex) {
            ex.printStackTrace();
        }
    } // end registerListener()

    /**
     * Unregisters the sensor's event listener.
     *
     * @param bandClient The BandClient whose event listener is unregistered.
     */
    @Override
    public void unregisterListener(BandClient bandClient) {
        try {
            bandClient.getSensorManager().unregisterContactEventListener(listener);
        } catch (BandIOException ex) {
            ex.printStackTrace();
        }
    } // end unregisterListener()

    public boolean getWorn() { return worn; }
}