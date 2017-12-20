import React from 'react';  //引入react组件
import '../scss/movie_info_page.scss';
import ActorsList from './actors_list';
import InnerMessager from './inner_messager';
import Director from "./director";
import TagsOfMovie from "./tags_of_movie";
var MovieInfoPage = React.createClass({
    getInitialState: function () {
        return {
            whenThereHaveNotActor: "无演员",
            whenThereHaveNotDirector: "无导演",
            whenMovieIsLoading: "正在加载电影信息",
            whenThereHaveNotTag: "无标签",
            whenTagIsLoading: "正在加载标签信息",
            movie: {},
            targetMovieId:this.props.match.params.movieId
        };
    }, componentDidMount: function () {
        window.addEventListener('resize', this.onWindowResize);

        //get movie
        this.getMovie();
    },

    componentWillUnmount: function () {
        window.removeEventListener('resize', this.onWindowResize);
    },

    onWindowResize: function () {
        this.adjustUI();
    },

    adjustUI: function () {

    },

    getMovie: function (callfun) {
        //show tip
        this.showTip(this.state.whenMovieIsLoading);


        var movieId = this.state.targetMovieId;


        //get movie info
        const url = this.props.match.url;
        // c(url);
        this.serverRequest = $.get(url, function (result) {


            //close tip
            this.showTip();

            if (fail(result.code)) {
                return;
            }

            var state = this.state;

            //set movie info to state

            state.movie = result.data.movie;

            this.setState(state);

            // c(this.state)
            //callfun
            if (callfun != undefined) {
                callfun()
            }
        }.bind(this));
    },
    showTip(msg, loop) {
        this.refs.innerMessager.showMsg(msg, loop);
    },
    render: function () {

        //format releaseTime
        var releaseTime = timeFormatter.formatDate(this.state.movie.releaseTime);

        return (
            <div id="movie_info_content">
                <div id="basic_info">

                    <InnerMessager defaultTip={this.state.whenMovieIsLoading}
                                   ref="innerMessager"/>
                    <div className="clearfix" id="movie_info_displayer">
                        <div id="movie_img">
                            <img src={this.state.movie.imgUrl}/>
                        </div>
                        <div id="movie_text">
                            <ul id="text_ul">
                                <li id="name_li">
                                    电影 : <a href="javascript:void(0);">{this.state.movie.name}</a>
                                </li>
                                <li>
                                    别名 : <a href="javascript:void(0);">{this.state.movie.alias}</a>
                                </li>
                                <li>
                                    上映时间 : <a href="javascript:void(0);">releaseTime</a>
                                </li>

                                <li>
                                    时长 : <a href="javascript:void(0);">{this.state.movie.movieTime}</a>
                                </li>

                                <li>
                                    评分 : <a href="javascript:void(0);">{this.state.movie.score}</a>
                                </li>

                                <li>

                                    <Director whenThereHaveNotDirector={this.state.whenThereHaveNotDirector}
                                              director={this.state.movie.director}/>

                                </li>
                                <li>
                                    <ActorsList whenThereHaveNotActor={this.state.whenThereHaveNotActor}
                                                actors={this.state.movie.actors}/>
                                </li>

                                <li>
                                    总播放数 : <a href="javascript:void(0);">{this.state.movie.watchNum}</a>
                                </li>

                                <li id="description_li">
                                    电影简介 : <a href="javascript:void(0);">{this.state.movie.description}</a>
                                </li>

                                <li>
                                    <TagsOfMovie movieId={this.state.targetMovieId}
                                                 whenThereHaveNotTag={this.state.whenThereHaveNotTag}
                                                 whenTagIsLoading={this.state.whenTagIsLoading}></TagsOfMovie>
                                </li>
                            </ul>
                        </div>
                    </div>

                </div>
                <div id="other_info"></div>
            </div>
        );
    }
});


export default MovieInfoPage;