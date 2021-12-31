package com.example.movieapps.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movieapps.R
import com.example.movieapps.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadContent() {
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))

        onView(withId(R.id.view_pager)).perform(swipeLeft())

        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))

        onView(withId(R.id.view_pager)).perform(swipeRight())
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[5].title)))

        onView(withId(R.id.tvTime)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTime)).check(matches(withText(dummyMovie[5].time)))

        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyMovie[5].rating.toString())))

        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(dummyMovie[5].date)))

        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyMovie[5].genre)))

        onView(withId(R.id.tvSinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tvSinopsis)).check(matches(withText(dummyMovie[5].synopsis)))

        onView(withId(R.id.imgPreview)).check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()))

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTvShow[5].title)))

        onView(withId(R.id.tvTime)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTime)).check(matches(withText(dummyTvShow[5].time)))

        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyTvShow[5].rating.toString())))

        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(withText(dummyTvShow[5].date)))

        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyTvShow[5].genre)))

        onView(withId(R.id.tvSinopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tvSinopsis)).check(matches(withText(dummyTvShow[5].synopsis)))

        onView(withId(R.id.imgPreview)).check(matches(isDisplayed()))

        pressBack()
    }
}