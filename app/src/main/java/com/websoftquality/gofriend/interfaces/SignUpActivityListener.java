package com.websoftquality.gofriend.interfaces;
/**
 * @package com.websoftquality.gofriend
 * @subpackage interfaces
 * @category SignUpActivityListener
 * @author Trioangle Product Team
 * @version 1.0
 **/

import android.content.res.Resources;

import com.websoftquality.gofriend.views.signup.SignUpActivity;

/*****************************************************************
 SignUpActivityListener
 ****************************************************************/


public interface SignUpActivityListener {

    Resources getRes();

    SignUpActivity getInstance();

}
