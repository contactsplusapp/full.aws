(defproject fullcontact/full.aws "0.10.11"
  :description "Async Amazon Webservices client."
  :url "https://github.com/contactsplusapp/full.aws"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  :repositories [["fullcontact" {:url "https://contactsplus.jfrog.io/artifactory/repo"}]
                 ["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local"}]
                 ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local"}]]
  :deploy-repositories [["releases" {:url "https://contactsplus.jfrog.io/artifactory/libs-release-local" :creds :gpg}]
                        ["snapshots" {:url "https://contactsplus.jfrog.io/artifactory/libs-snapshot-local"}]]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.amazonaws/aws-java-sdk "1.11.16"]
                 [com.taoensso/faraday "1.7.1" ; DynamoDB sugar
                  :exclusions [com.amazonaws/aws-java-sdk-dynamodb joda-time]]
                 [fullcontact/full.http "1.0.9"]
                 [fullcontact/full.json "0.12.0"
                  :exclusions [com.fasterxml.jackson.core/jackson-core]]
                 [fullcontact/full.async "0.9.0"]
                 [fullcontact/full.core "0.10.1"
                  :exclusions [org.clojure/clojurescript]]
                 [javax.xml.bind/jaxb-api "2.4.0-b180830.0359"]
                 [com.fasterxml.jackson.core/jackson-annotations "2.6.0"]]
  :aot :all
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
