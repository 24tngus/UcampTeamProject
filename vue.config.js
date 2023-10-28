module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8087',
                changeOrigin: true,
                pathRewrite: {
                    '^/': ''
                }
            }
        }
    },
    chainWebpack: (config) => {
        config.module
            .rule("html")
            .test(/\.html$/)
            .use("html-loader")
            .loader("html-loader")
            .end();
    },
}