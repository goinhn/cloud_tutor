var webpack = require('webpack');
module.exports = {
    entry: {
        packIndex: './js/index.js',
        packLogin: './js/login.js',
        packRegister: './js/register.js',
        packRecruitment: './js/recruitment.js',
        packTutorInformation: './js/tutorInformation.js',
        packDetails: './js/details.js',
        packUtils: './js/utils/utils.js'
    },
    output: {
        filename: './dist/[name].js'
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    devServer: {
        port: 5555,
        inline: true,
        hot: true
    }
}