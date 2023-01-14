# pokemon_translation_api
ポケモン外国語名の翻訳APIです。

## 使い方
### 全件取得
翻訳情報を全件取得します。

エンドポイント：http://localhost:8091/v1/translations

### ポケモン別の翻訳情報の取得
特定のポケモンの翻訳情報を取得します。

検索可能なポケモン名は、日本語・英語・ドイツ語・フランス語・韓国語・中国語（簡）・中国語（繁）に対応しています。

エンドポイント：http://localhost:8091/v1/translations/{name}


## 対応言語
次の言語に対応しています。
* 日本語
* 英語
* ドイツ語
* フランス語
* 韓国語
* 中国語（簡）
* 中国語（繁）

## 開発
### ビルド環境
VSCodeの[Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)の使用を推奨。

### 構成
* web
  * アプリケーションサーバーのコンテナです。
  * Java 17
  * 8091番ポートをフォワーディングしています。
* db
  * データベースサーバーのコンテナです。
  * MySQL 5.7
* phpmyadmin
  * データベースクライアントのコンテナです。
  * データベース閲覧用。
  * 8090番ポートをフォワーディングしています。
