package com.websoftquality.gofriend.dependencies.component;
/**
 * @package com.websoftquality.gofriend
 * @subpackage dependencies.component
 * @category AppComponent
 * @author Trioangle Product Team
 * @version 1.0
 **/

import javax.inject.Singleton;

import dagger.Component;
import com.websoftquality.gofriend.adapters.chat.ChatConversationListAdapter;
import com.websoftquality.gofriend.adapters.chat.MessageUserListAdapter;
import com.websoftquality.gofriend.adapters.chat.NewMatchesListAdapter;
import com.websoftquality.gofriend.adapters.chat.UserListAdapter;
import com.websoftquality.gofriend.adapters.main.ProfileSliderAdapter;
import com.websoftquality.gofriend.adapters.main.QuestionsAdapter;
import com.websoftquality.gofriend.adapters.matches.MatchesSwipeAdapter;
import com.websoftquality.gofriend.adapters.chat.UnmatchReasonListAdapter;
import com.websoftquality.gofriend.adapters.profile.EditProfileImageListAdapter;
import com.websoftquality.gofriend.adapters.profile.EnlargeSliderAdapter;
import com.websoftquality.gofriend.adapters.profile.IgniterSliderAdapter;
import com.websoftquality.gofriend.adapters.profile.LocationListAdapter;
import com.websoftquality.gofriend.backgroundtask.ImageCompressAsyncTask;
import com.websoftquality.gofriend.configs.RunTimePermission;
import com.websoftquality.gofriend.configs.SessionManager;
import com.websoftquality.gofriend.dependencies.module.AppContainerModule;
import com.websoftquality.gofriend.dependencies.module.ApplicationModule;
import com.websoftquality.gofriend.dependencies.module.NetworkModule;
import com.websoftquality.gofriend.layoutmanager.SwipeableTouchHelperCallback;
import com.websoftquality.gofriend.likedusers.LikedUserAdapter;
import com.websoftquality.gofriend.likedusers.LikedUsersActivity;
import com.websoftquality.gofriend.pushnotification.MyFirebaseInstanceIDService;
import com.websoftquality.gofriend.pushnotification.MyFirebaseMessagingService;
import com.websoftquality.gofriend.pushnotification.NotificationUtils;
import com.websoftquality.gofriend.swipedeck.Utility.SwipeListener;
import com.websoftquality.gofriend.utils.CommonMethods;
import com.websoftquality.gofriend.utils.DateTimeUtility;
import com.websoftquality.gofriend.utils.ImageUtils;
import com.websoftquality.gofriend.utils.RequestCallback;
import com.websoftquality.gofriend.utils.WebServiceUtils;
import com.websoftquality.gofriend.views.chat.ChatConversationActivity;
import com.websoftquality.gofriend.views.chat.ChatFragment;
import com.websoftquality.gofriend.views.chat.CreateGroupActivity;
import com.websoftquality.gofriend.views.chat.MatchUsersActivity;
import com.websoftquality.gofriend.views.main.BoostDialogActivity;
import com.websoftquality.gofriend.views.main.HomeActivity;
import com.websoftquality.gofriend.views.main.IgniterGoldActivity;
import com.websoftquality.gofriend.views.main.IgniterPageFragment;
import com.websoftquality.gofriend.views.main.IgniterPlusDialogActivity;
import com.websoftquality.gofriend.views.main.IgniterPlusSliderFragment;
import com.websoftquality.gofriend.views.main.LoginActivity;
import com.websoftquality.gofriend.views.main.SplashActivity;
import com.websoftquality.gofriend.views.main.StripeCardPaymentActivity;
import com.websoftquality.gofriend.views.main.TutorialFragment;
import com.websoftquality.gofriend.views.main.UserNameActivity;
import com.websoftquality.gofriend.views.main.VerificationActivity;
import com.websoftquality.gofriend.views.main.AccountKit.FacebookAccountKitActivity;
import com.websoftquality.gofriend.views.main.AccountKit.TwilioAccountKitActivity;
import com.websoftquality.gofriend.views.profile.AddLocationActivity;
import com.websoftquality.gofriend.views.profile.AdvancedSettings;
import com.websoftquality.gofriend.views.profile.EditProfileActivity;
import com.websoftquality.gofriend.views.profile.EnlargeProfileActivity;
import com.websoftquality.gofriend.views.profile.GetIgniterPlusActivity;
import com.websoftquality.gofriend.views.profile.ProfileFragment;
import com.websoftquality.gofriend.views.profile.SettingsActivity;
import com.websoftquality.gofriend.views.signup.BirthdayFragment;
import com.websoftquality.gofriend.views.signup.EmailFragment;
import com.websoftquality.gofriend.views.signup.GenderFragment;
import com.websoftquality.gofriend.views.signup.OneTimePwdFragment;
import com.websoftquality.gofriend.views.signup.PasswordFragment;
import com.websoftquality.gofriend.views.signup.PhoneNumberFragment;
import com.websoftquality.gofriend.views.signup.ProfilePickFragment;
import com.websoftquality.gofriend.views.signup.SignUpActivity;

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


    void inject(StripeCardPaymentActivity stripeCardPaymentActivity);

    void inject(QuestionsAdapter questionsAdapter);

    void inject(AdvancedSettings advancedSettings);
}
