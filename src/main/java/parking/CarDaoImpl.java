package parking;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class CarDaoImpl implements CarDao{
    @Override
    public boolean isVip(String carName) {
        return StringUtils.contains(carName,"vip");
    }
}
