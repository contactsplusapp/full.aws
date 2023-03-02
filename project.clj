(defproject fullcontact/full.aws "0.10.13"
  :description "Async Amazon Webservices client."
  :url "https://github.com/contactsplusapp/full.aws"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :repositories [["fullcontact" {:url "https://contactsplus.jfrog.io/artifactory/repo"}]
                 ["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local"}]
                 ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local"}]]
  :deploy-repositories [["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local" :sign-releases false}]
                        ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local" :sign-releases false}]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.amazonaws/aws-java-sdk "1.11.16"]
                 [com.taoensso/faraday "1.11.1" ; DynamoDB sugar
                  :exclusions [com.amazonaws/aws-java-sdk-dynamodb joda-time]]
                 [fullcontact/full.http "1.0.11"]
                 [fullcontact/full.json "0.10.3"]
                 [fullcontact/full.async "1.1.1"]
                 [fullcontact/full.core "1.1.3"
                  :exclusions [org.clojure/clojurescript]]]
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]
  :plugins [[lein-midje "3.1.3"]]
  :profiles {:dev {:dependencies [[midje "1.7.0"]]}})
