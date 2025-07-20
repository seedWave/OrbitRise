let view = {};
(function (view) {
    function sigmUpView(){
        $('.login_wrap').removeClass('active');
        $('.sign_up_wrap').addClass('active');
    }
    function signUpClose(){
        $('.sign_up_wrap').removeClass('active');
        $('.login_wrap').addClass('active');
    }
    view.sigmUpView = sigmUpView;
    view.signUpClose = signUpClose;
})(view)