package com.datingapp.dependencies.component;
/**
 * @package com.datingapp
 * @subpackage dependencies.component
 * @category AppComponent
 * @author Trioangle Product Team
 * @version 1.0
 **/

import javax.inject.Singleton;

import dagger.Component;
import com.datingapp.adapters.chat.ChatConversationListAdapter;
import com.datingapp.adapters.chat.MessageUserListAdapter;
import com.datingapp.adapters.chat.NewMatchesListAdapter;
import com.datingapp.adapters.chat.UserListAdapter;
import com.datingapp.adapters.main.ProfileSliderAdapter;
import com.datingapp.adapters.matches.MatchesSwipeAdapter;
import com.datingapp.adapters.chat.UnmatchReasonListAdapter;
import com.datingapp.adapters.profile.EditProfileImageListAdapter;
import com.datingapp.adapters.profile.EnlargeSliderAdapter;
import com.datingapp.adapters.profile.IgniterSliderAdapter;
import com.datingapp.adapters.profile.LocationListAdapter;
import com.datingapp.backgroundtask.ImageCompressAsyncTask;
import com.datingapp.configs.RunTimePermission;
import com.datingapp.configs.SessionManager;
import com.datingapp.dependencies.module.AppContainerModule;
import com.datingapp.dependencies.module.ApplicationModule;
import com.datingapp.dependencies.module.NetworkModule;
import com.datingapp.layoutmanager.SwipeableTouchHelperCallback;
import com.datingapp.likedusers.LikedUserAdapter;
import com.datingapp.likedusers.LikedUsersActivity;
import com.datingapp.pushnotification.MyFirebaseInstanceIDService;
import com.datingapp.pushnotification.MyFirebaseMessagingService;
import com.datingapp.pushnotification.NotificationUtils;
import com.datingapp.swipedeck.Utility.SwipeListener;
import com.datingapp.utils.CommonMethods;
import com.datingapp.utils.DateTimeUtility;
import com.datingapp.utils.ImageUtils;
import com.datingapp.utils.RequestCallback;
import com.datingapp.utils.WebServiceUtils;
import com.datingapp.views.chat.ChatConversationActivity;
import com.datingapp.views.chat.ChatFragment;
import com.datingapp.views.chat.CreateGroupActivity;
import com.datingapp.views.chat.MatchUsersActivity;
import com.datingapp.views.main.BoostDialogActivity;
import com.datingapp.views.main.HomeActivity;
import com.datingapp.views.main.IgniterGoldActivity;
import com.datingapp.views.main.IgniterPageFragment;
import com.datingapp.views.main.IgniterPlusDialogActivity;
import com.datingapp.views.main.IgniterPlusSliderFragment;
import com.datingapp.views.main.LoginActivity;
import com.datingapp.views.main.SplashActivity;
import com.datingapp.views.main.TutorialFragment;
import com.datingapp.views.main.UserNameActivity;
import com.datingapp.views.main.VerificationActivity;
import com.datingapp.views.main.AccountKit.FacebookAccountKitActivity;
import com.datingapp.views.main.AccountKit.TwilioAccountKitActivity;
import com.datingapp.views.profile.AddLocationActivity;
import com.datingapp.views.profile.EditProfileActivity;
import com.datingapp.views.profile.EnlargeProfileActivity;
import com.datingapp.views.profile.GetIgniterPlusActivity;
import com.datingapp.views.profile.ProfileFragment;
import com.datingapp.views.profile.SettingsActivity;
import com.datingapp.views.signup.BirthdayFragment;
import com.datingapp.views.signup.EmailFragment;
import com.datingapp.views.signup.GenderFragment;
import com.datingapp.views.signup.OneTimePwdFragment;
import com.datingapp.views.signup.PasswordFragment;
import com.datingapp.views.signup.PhoneNumberFragment;
import com.datingapp.views.signup.ProfilePickFragment;
import com.datingapp.views.signup.SignUpActivity;

/*****************************************************************
 App Component
 ****************************************************************/
@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class, AppContainerModule.class})
public interface AppComponent {
    // ACTIVITY

    void inject(SplashActivity splashActivity);

    void inject(HomeActivity homeActivity);

    void inject(SettingsActivity settingsActivity);

    void inject(EditProfileActivity editProfileActivity);

    void inject(GetIgniterPlusActivity getIgniterPlusActivity);

    void inject(SignUpActivity signUpActivity);

    void inject(EnlargeProfileActivity enlargeProfileActivity);

    void inject(MatchUsersActivity matchUsersActivity);

    void inject(ChatConversationActivity chatConversationActivity);

    void inject(CreateGroupActivity createGroupActivity);

    void inject(LoginActivity loginActivity);

    void inject(VerificationActivity verificationActivity);

    void inject(UserNameActivity userNameActivity);

    void inject(AddLocationActivity addLocationActivity);

    void inject(FacebookAccountKitActivity facebookAccountKitActivity);

    void inject(TwilioAccountKitActivity facebookAccountKitActivity1);

    void inject(IgniterGoldActivity igniterGoldActivity);

    void inject(LikedUsersActivity likedUsersActivity);


    // Fragments
    void inject(ProfileFragment profileFragment);

    void inject(IgniterPageFragment igniterPageFragment);

    void inject(ChatFragment chatFragment);

    void inject(ProfilePickFragment profilePickFragment);

    void inject(EmailFragment emailFragment);

    void inject(PasswordFragment passwordFragment);

    void inject(BirthdayFragment birthdayFragment);

    void inject(TutorialFragment tutorialFragment);

    void inject(PhoneNumberFragment phoneNumberFragment);

    void inject(OneTimePwdFragment oneTimePwdFragment);

    void inject(GenderFragment genderFragment);

    void inject(IgniterPlusDialogActivity igniterPlusDialogActivity);

    void inject(BoostDialogActivity boostDialogActivity);

    void inject(IgniterPlusSliderFragment igniterPlusSliderFragment);

    // Utilities
    void inject(RunTimePermission runTimePermission);

    void inject(SessionManager sessionManager);

    void inject(ImageUtils imageUtils);

    void inject(CommonMethods commonMethods);

    void inject(ProfileSliderAdapter profileSliderAdapter);

    void inject(RequestCallback requestCallback);

    void inject(DateTimeUtility dateTimeUtility);

    void inject(WebServiceUtils webServiceUtils);

    // Adapters
    void inject(IgniterSliderAdapter igniterSliderAdapter);

    void inject(NewMatchesListAdapter newMatchesListAdapter);

    void inject(MessageUserListAdapter messageUserListAdapter);

    void inject(EnlargeSliderAdapter enlargeSliderAdapter);

    void inject(EditProfileImageListAdapter editProfileImageListAdapter);

    void inject(ChatConversationListAdapter chatConversationListAdapter);

    void inject(UnmatchReasonListAdapter unmatchReasonListAdapter);

    void inject(UserListAdapter chatUserListAdapter);

    void inject(MatchesSwipeAdapter matchesSwipeAdapter);

    void inject(SwipeListener swipeListener);

    void inject(LocationListAdapter locationListAdapter);

    void inject(LikedUserAdapter likedUserAdapter);

    void inject(MyFirebaseMessagingService myFirebaseMessagingService);

    void inject(MyFirebaseInstanceIDService myFirebaseInstanceIDService);


    // AsyncTask
    void inject(ImageCompressAsyncTask imageCompressAsyncTask);

    void inject(NotificationUtils notificationUtils);

    void inject(SwipeableTouchHelperCallback swipeableTouchHelperCallback);


}
