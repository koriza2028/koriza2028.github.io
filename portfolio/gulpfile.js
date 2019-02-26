const gulp = require('gulp');
const autoprefixer = require('gulp-autoprefixer');
const browserSync = require('browser-sync').create();
const uglify = require('gulp-uglifyjs');

gulp.task('css', () => {
    return gulp.src('dev/css/*.css')
                .pipe(autoprefixer(['last 15 versions', '> 1%', 'ie 8', 'ie 7'], {
                     cascade: true
                })
                )
                .pipe(gulp.dest('dist/css'))
                .pipe(browserSync.stream());
});

gulp.task('browserSync', () => {
    browserSync.init({
        injectChanges: true,
        server: {
            baseDir: './'
        },
        notify: false,
        tunnel: true
    });
});

gulp.task('script', () => {
    return gulp.src('dev/js/*.js')
               //.pipe(uglify())
               .pipe(gulp.dest('dist/js'))
               .pipe(browserSync.stream());
});

gulp.task('watch', () => {
    gulp.watch('dev/css/*.css', gulp.parallel('css'));
    gulp.watch('dev/js/*.js', gulp.parallel('script'));
    gulp.watch('./index.html', browserSync.reload);
})


gulp.task('default', gulp.parallel('browserSync', 'css', 'watch', 'script'));
