package com.datingapp.interfaces;
/**
 * @package com.datingapp
 * @subpackage interfaces
 * @category SignUpActivityListener
 * @author Trioangle Product Team
 * @version 1.0
 **/

import android.content.res.Resources;

import com.datingapp.views.signup.SignUpActivity;

/*****************************************************************
 SignUpActivityListener
 ****************************************************************/


public interface SignUpActivityListener {

    Resources getRes();

    SignUpActivity getInstance();

}
