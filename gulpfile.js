'use strict';

var gulp            = require('gulp'),
    concat          = require('gulp-concat'),
    // uglify          = require('gulp-uglify'),
    sass            = require('gulp-sass'),
    autoprefixer    = require('gulp-autoprefixer'),
//     wrapper         = require('gulp-wrapper'),
    minifycss       = require('gulp-minify-css');

var del             = require('del');

var paths           = require('./gulp/dependencies.js');


// TASKS

gulp.task('styles', ['clean'], function(){
  return gulp.src(paths.css_files)
  .pipe(concat('bundle.css'))
  .pipe(sass({
    includePaths: paths.css
  }))
  .pipe(autoprefixer())
  .pipe(minifycss({
    keepSpecialComments: 0
  }))
  .pipe(gulp.dest('./public/stylesheets'));
});

// gulp.task('others', function(){
//   return gulp.src(paths.others)
//     .pipe(gulp.dest('public/lib'));
// });

gulp.task('clean', function(cb) {
  del(['public/assets/stylesheets/*'], cb);
});

// gulp.task('scripts', function() {
//   return gulp.src(paths.js)
//     .pipe(concat('application.js'))
//     .pipe(gulp.dest('public/javascripts'))
// });

// gulp.task('icons', function() {
//   return gulp.src(paths.fonts)
//     .pipe(gulp.dest('public/fonts'));
// });

// gulp.task('icons-bootstrap', function(){
//   return gulp.src(paths.fonts_bootstrap)
//     .pipe(gulp.dest('public/fonts/bootstrap'));
// });

gulp.task('watch', function(){
   gulp.watch(paths.css_watch, ['styles']);
});

// // DEFAULT

gulp.task('default', ['styles', 'watch']);

// gulp.task('default', ['styles', 'icons', 'icons-bootstrap', 'scripts', 'watch', 'others']);