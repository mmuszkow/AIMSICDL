/* Android IMSI-Catcher Detector | (c) AIMSICD Privacy Project
 * -----------------------------------------------------------
 * LICENSE:  http://git.io/vki47 | TERMS:  http://git.io/vki4o
 * -----------------------------------------------------------
 */
package zz.aimsicd.lite.utils;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.freefair.android.util.function.Function;
import zz.aimsicd.lite.R;
import zz.aimsicd.lite.enums.Status;

/**
 * Class that holds and returns the correct icon based on requested icon format and
 * current system status.
 *
 */
public class Icon {

    public enum Type {

        // FLAT Icon-Style
        FLAT(
                new Function<Status, Integer>() {
                    @NonNull
                    @Override
                    public Integer apply(Status status) {
                        switch (status) {
                            case IDLE:
                                return R.drawable.flat_idle;
                            case OK:
                                return R.drawable.flat_ok;
                            case MEDIUM:
                                return R.drawable.flat_medium;
                            case HIGH:
                                return R.drawable.flat_high;
                            case DANGER:
                                return R.drawable.flat_danger;
                            case SKULL:
                                return R.drawable.flat_skull;
                            default:
                                return R.drawable.flat_idle;
                        }
                    }
                }
        ),

         // SENSE Icon-Style
        SENSE(
                new Function<Status, Integer>() {
                    @NonNull
                    @Override
                    public Integer apply(@Nullable Status status) {
                        switch (status) {
                            case IDLE:
                                return R.drawable.sense_idle;
                            case OK:
                                return R.drawable.sense_ok;
                            case MEDIUM:
                                return R.drawable.sense_medium;
                            case HIGH:
                                return R.drawable.sense_high;
                            case DANGER:
                                return R.drawable.sense_danger;
                            case SKULL:
                                return R.drawable.sense_skull;
                            default:
                                return R.drawable.sense_idle;
                        }
                    }
                }
        ),

        // WHITE Icon-Style
        WHITE(
                new Function<Status, Integer>() {
                    @NonNull
                    @Override
                    public Integer apply(@Nullable Status status) {
                        switch (status) {
                            case IDLE:
                                return R.drawable.white_idle;
                            case OK:
                                return R.drawable.white_ok;
                            case MEDIUM:
                                return R.drawable.white_medium;
                            case HIGH:
                                return R.drawable.white_high;
                            case DANGER:
                                return R.drawable.white_danger;
                            case SKULL:
                                return R.drawable.white_skull;
                            default:
                                return R.drawable.white_idle;
                        }
                    }
                }
        );

        Function<Status, Integer> iconMapper;

        Type(Function<Status, Integer> iconMapper) {
            this.iconMapper = iconMapper;
        }
    }

    /**
     * Returns a icon of the Type $t, what kind of icon is returned is decided
     * from what the current status is.
     */
    @DrawableRes
    public static int getIcon(Type type, Status status) {
        return type.iconMapper.apply(status);
    }
}
