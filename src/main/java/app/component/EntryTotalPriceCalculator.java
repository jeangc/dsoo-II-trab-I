package app.component;

import app.entity.EntryEntity;
import app.entity.SettingsEntity;

import java.sql.Timestamp;

public class EntryTotalPriceCalculator {
    static public void calculate(SettingsEntity s, EntryEntity entry) {
        float t = getPassedMinutes(entry.getEntrada());

        entry.setTempoTotal(t);
        entry.setValorTotal(calculateValue(s, t));
    }

    static private float calculateValue(SettingsEntity s, float t) {
        if (t <= s.getToleranciaMinutos()) {
            return 0;
        }

        if (t <= s.getPeriodoInicialMinutos()) {
            return s.getValorInicial();
        }

        float semInicial = t - s.getPeriodoInicialMinutos();
        float periodos = (float) Math.ceil((float) semInicial / s.getPeriodoMinutos());

        return s.getValorInicial() + (s.getValorPeriodo() * periodos);
    }


    static private float getPassedMinutes(Timestamp early) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        return (now.getTime() - early.getTime()) / (60 * 1000);
    }
}
