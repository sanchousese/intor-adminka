module.exports = {
  js: [
    'bower_components/jquery/dist/jquery.js',
    'bower_components/bootstrap-sass/assets/javascripts/bootstrap.js',
    'bower_components/vue/dist/vue.js',
    'bower_components/zeroclipboard/dist/ZeroClipboard.js',
    'bower_components/jquery.countdown/dist/jquery.countdown.js',
    'app/assets/js/*.js'
  ],
  js_watch: [
    'app/assets/js/*.js'
  ],
  others: [
    'bower_components/zeroclipboard/dist/ZeroClipboard.swf'
  ],
  css: [
    'bower_components/bootstrap-sass/assets/stylesheets',
    'app/assets/sass'
  ],
	css_files: [
    'bower_components/bootstrap-sass/assets/stylesheets/_bootstrap.scss',
    'app/assets/sass/main.scss'
	],
  fonts: [
    'bower_components/fontawesome/fonts/**.*'
  ],
  fonts_bootstrap: [
    'bower_components/bootstrap-sass/assets/fonts/bootstrap/**.*'
  ],
  css_watch: [
    'app/assets/sass/**/*.scss',
    'app/assets/sass/main.scss'
  ]
}