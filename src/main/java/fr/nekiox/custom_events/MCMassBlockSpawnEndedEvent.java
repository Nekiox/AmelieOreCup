package fr.nekiox.custom_events;

import fr.nekiox.mineral.Utils.MassBlockSpawner;
import lombok.Getter;

public class MCMassBlockSpawnEndedEvent extends MCEvent{

    @Getter
    private MassBlockSpawner spawner;

    public MCMassBlockSpawnEndedEvent(MassBlockSpawner spawner) {
        this.spawner = spawner;
    }
}
