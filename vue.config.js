module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8087',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            },
            '/ROOT': {
                target: 'http://127.0.0.1:8080/',
                changeOrigin: true,
                logLevel: 'debug'
            },
            '/oauth2.0': {
                target: 'https://nid.naver.com/',
                changeOrigin: true,
                logLevel: 'debug'
            },
            '/v1': {
                target: 'https://openapi.naver.com/',
                changeOrigin: true,
                logLevel: 'debug'
            }
        },
        port: 8087
    }
};