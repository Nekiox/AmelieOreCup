package fr.nekiox.challenges.Availables;

import fr.nekiox.challenges.ChallengeManager;

public abstract class AbstractRepeatableChallenge extends AbstractChallenge{

    public AbstractRepeatableChallenge(ChallengeManager manager) {
        super(manager);
    }

    /**
     * Retourne le nombre de fois où l'objectif doit être atteint pour récuperer la récompense
     * @return
     */
    public abstract int repetitionNeeded();
}
